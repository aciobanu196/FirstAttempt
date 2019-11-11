package http

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes._
import DBrelated.Products
import Services.ShopService
import spray.json.DefaultJsonProtocol


class Routes(name:ShopService) {

  trait Protocols extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val shopFormat = jsonFormat4(Products)

    class ProductRoutes(val shopService: ShopService) extends Protocols {

      val route = logRequestResult("ProductRoutes") {
        pathPrefix("products") {
          pathEndOrSingleSlash {
            get {
              complete {
                shopService.getProducts()
              }
            } ~
              post {
                entity(as[Products]) { productForCreate =>
                  complete {
                    shopService.createProduct(productForCreate)
                  }
                }
              }
          }
        }
      }
    }

  }

}