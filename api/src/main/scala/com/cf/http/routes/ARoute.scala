package com.cf.http.routes

import akka.http.scaladsl.model.{HttpRequest, StatusCodes}
import com.codefactory.ecommerce.services.AService
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import akka.http.scaladsl.server.Directives._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.auto._
import io.circe.syntax._

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

final case class ARoute(private val aService: AService) extends LazyLogging {

  //curl -X GET http://localhost:8080/ecommerce-api/products
  //output example [{"id":1,"name":"as","price":2,"typeID":2,"quantity":4,"isDeleted":false}]
  def routes()(implicit ec: ExecutionContext, db: backend.Database, request: HttpRequest) =
    path("products") {
      get {
        onComplete(aService.getProducts()) {
          case Success(it) => complete(it)
          case Failure(e) => complete(StatusCodes.InternalServerError -> e)
        }
      }
    }

}
