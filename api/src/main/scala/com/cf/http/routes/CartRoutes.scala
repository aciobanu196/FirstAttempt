package com.cf.http.routes

import akka.http.scaladsl.model.{HttpRequest, StatusCodes}
import com.codefactory.ecommerce.services.CartsService
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import akka.http.scaladsl.server.Directives._
import com.codefactory.ecommerce.httpModel.ProductsAndQuantities
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.auto._
import io.circe.syntax._
import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

final case class CartRoutes(private val cartService: CartsService)
    extends LazyLogging {

  def routes()(
      implicit ec: ExecutionContext,
      db: backend.Database,
      request: HttpRequest
  ) =
    pathPrefix("cart") {
      pathPrefix(IntNumber) { userId =>
        post {
          entity(as[List[ProductsAndQuantities]]) { productsAndQuantities =>
            onComplete(cartService.postCart(userId, productsAndQuantities)) {
              case Success(it) => complete(it)
              case Failure(e) =>
                complete(StatusCodes.InternalServerError -> e)
            }
          }
        }
      }
    }
}
