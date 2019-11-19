package com.codefactory.ecommerce.tableQuerryVariable

import com.codefactory.ecommerce.tableDef.{
  BankT,
  CartT,
  OrderT,
  ProductT,
  TypeT,
  UserT
}
import slick.lifted.TableQuery

import slick.jdbc.MySQLProfile.api._

trait QuerryVariable {

  val db = Database.forConfig("mydb")

  final val banks = TableQuery[BankT]
  final val carts = TableQuery[CartT]
  final val orders = TableQuery[OrderT]
  final val products = TableQuery[ProductT]
  final val types = TableQuery[TypeT]
  final val users = TableQuery[UserT]

}
