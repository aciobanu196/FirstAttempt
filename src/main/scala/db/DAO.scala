//package db
//
//import DBrelated.Products
//import DBrelated.Cart
//import DBrelated.Customer
//import com.typesafe.scalalogging.LazyLogging
//import slick.jdbc.JdbcProfile
//
//// This should be correct, but incomplete,
//// need to recheck the specification of the problem in order to make sure I dont need more complex queries,
//// most likely what I am missing should be a relation between Products table and Cart
//// But I do need to have a closer look
//case class DAO(val driver: JdbcProfile) {
//
//  import driver.api._
//
//  class ShopT(tag: Tag) extends Table[Products](tag, "SHOP") {
//    def id = column[Long]("PRODUCT_ID", O.PrimaryKey, O.AutoInc)
//
//    def productName = column[String]("PRODUCT_NAME")
//
//    def productPrice = column[String]("PRODUCT_PRICE")
//
//    def productType = column[String]("PRODUCT_TYPE")
//
//    def * =
//      (id.?, productName, productPrice, productType) <> ((Products.apply _).tupled, Products.unapply)
//  }
//
//  class ShoppingCart(tag: Tag) extends Table[Cart](tag, "CART") {
//    def id = column[Long]("PRODUCT_ID", O.PrimaryKey, O.AutoInc)
//
//    def productName = column[String]("PRODUCT_NAME")
//
//    def productPrice = column[String]("PRODUCT_PRICE")
//
//    def totalPrice = column[String]("TOTAL_PRICE")
//
//    def * =
//      (id.?, productName, productPrice, totalPrice) <> ((Cart.apply _).tupled, Cart.unapply)
//  }
//
//  class CustomerT(tag: Tag) extends Table[Customer](tag, "CUSTOMER") {
//    def id = column[Long]("CUSTOMER_ID", O.PrimaryKey, O.AutoInc)
//
//    def customerName = column[String]("CUSTOMER_NAME")
//
//    def customerEmail = column[String]("CUSTOMER_EMAIL")
//
//    def customerAddress = column[String]("CUSTOMER_ADDRESS")
//
//    def * =
//      (id.?, customerName, customerName, customerAddress) <> ((Customer.apply _).tupled, Customer.unapply)
//
//  }
//
//}

//PLACEHOLDER TO BE RE-USED IN THE NEW MODULE
