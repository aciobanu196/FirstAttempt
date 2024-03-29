package com.cf.http.routes

import akka.http.scaladsl.model.{HttpRequest, StatusCodes}
import com.codefactory.ecommerce.services.ProductsService
import com.codefactory.ecommerce.tableModel.Product
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import akka.http.scaladsl.server.Directives._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.auto._
import io.circe.syntax._
import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

final case class ProductsRoutes(private val productsService: ProductsService)
    extends LazyLogging {

  def routes()(
      implicit ec: ExecutionContext,
      db: backend.Database,
      request: HttpRequest
  ) = {
    pathPrefix("products") {
      pathEndOrSingleSlash {
        {
          get {
            onComplete(productsService.getProducts()) {
              case Success(it) => complete(it)
              case Failure(e)  => complete(StatusCodes.InternalServerError -> e)
            }
          } ~
            post {
              entity(as[Product]) { productToCreate =>
                onComplete(productsService.postProduct(productToCreate)) {
                  case Success(it) => complete(it)
                  case Failure(e) =>
                    complete(StatusCodes.InternalServerError -> e)
                }
              }
            }
        }

      } ~
        pathPrefix(IntNumber) { id =>
          get {
            onComplete(productsService.getProductById(id)) {
              case Success(it) => complete(it)
              case Failure(e)  => complete(StatusCodes.InternalServerError -> e)
            }
          }
        } ~
        pathPrefix(IntNumber) {
          { id =>
            put {
              entity(as[Product]) { productForUpdate =>
                onComplete(
                 productsService.putProduct(id, productForUpdate)
                ) {
                  case Success(it) => complete(it)
                  case Failure(e) =>
                    complete(StatusCodes.InternalServerError -> e)
                }
              }
            }
          }
        } ~
        pathPrefix("typeAsc") {
          get {
            onComplete(productsService.getProductByTypeAsc()) {
              case Success(it) => complete(it)
              case Failure(e)  => complete(StatusCodes.InternalServerError -> e)
            }
          }
        } ~
        pathPrefix("typeDesc") {
          get {
            onComplete(productsService.getProductByTypeDesc()) {
              case Success(it) => complete(it)
              case Failure(e)  => complete(StatusCodes.InternalServerError -> e)
            }
          }
        }
    }
  }
}
