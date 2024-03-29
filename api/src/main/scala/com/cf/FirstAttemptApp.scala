package com.cf

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.Materializer
import com.cf.http.routes.{CartRoutes, ProductsRoutes}
import com.codefactory.ecommerce.repositories.{
  CartRepository,
  ProductRepository
}
import com.codefactory.ecommerce.services.{CartsService, ProductsService}
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
  lazy val croute = CartRoutes(cartService)
  lazy val proute = ProductsRoutes(productService)

  //services
  lazy val cartService = CartsService(cartRepository)
  lazy val productService = ProductsService(productRepository)

  //repositories
  lazy val cartRepository = CartRepository()
  lazy val productRepository = ProductRepository()

  logger.info(s"Starting HTTP server on $host:$port")

  lazy val routes = extractRequest { implicit request =>
    pathPrefix(`service-name`) {
      croute.routes() ~ proute.routes()
    }
  }

  val bindingFuture = Http().bindAndHandle(routes, host, port)

}
