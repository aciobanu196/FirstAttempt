//package http

//import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport - // Deprecated not available on Scala 2.13.0 need to have a closer look at circe :(
import akka.http.scaladsl.server.Directives._
//import akka.http.scaladsl.model.StatusCodes._
//import DBrelated.Products
//import Services.ShopService // Deprecated as well, used for testing purposes with Scala 2.12.1
//import spray.json.DefaultJsonProtocol

// The paths should be correct just need to find the proper way tu use the JSON formatter

//class Routes(name:ShopService) {
//
//  trait Protocols extends SprayJsonSupport with DefaultJsonProtocol {
//    implicit val shopFormat = jsonFormat4(Products)
//
//    class ProductRoutes(val shopService: ShopService) extends Protocols {
//
//      val route = logRequestResult("ProductRoutes") {
//        pathPrefix("products") {
//          pathEndOrSingleSlash {
//            get {
//              complete {
//                shopService.getProducts()
//              }
//            } ~
//              post {
//                entity(as[Products]) { productForCreate =>
//                  complete {
//                    shopService.createProduct(productForCreate)
//                  }
//                }
//              }
//          }
//        }
//      }
//    }
//
//  }
//
//}

//PLACEHOLDER
