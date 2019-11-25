package com.cf

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.Materializer
import com.cf.http.routes.ARoute
import com.codefactory.ecommerce.repositories.{ARepository, CartRepository}
import com.codefactory.ecommerce.services.CartsService
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.api._
import akka.http.scaladsl.server.Directives._

object FirstAttemptApp extends App with LazyLogging {

  //environment
  implicit val system = ActorSystem("FirstAttempt")
  implicit val materializer = Materializer(system)
  implicit val executionContext = system.dispatchers.lookup("dispatcher")
  implicit val config = system.settings.config
  implicit val db = Database.forConfig("mysql.ecommerce")

  //configs
  lazy val host = config.getString("service.host")
  lazy val port = config.getInt("service.port")
  lazy val `service-name` = config.getString("service.name")

  //routes
  lazy val aroute = ARoute(cartService)

  //services
  lazy val cartService = CartsService(cartRepository)

  //repositories
  lazy val cartRepository = CartRepository()

  logger.info(s"Starting HTTP server on $host:$port")

  lazy val routes = extractRequest { implicit request =>
    pathPrefix(`service-name`) {
      aroute.routes()
    }
  }

  val bindingFuture = Http().bindAndHandle(routes, host, port)

}
