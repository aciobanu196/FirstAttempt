package com.codefactory.ecommerce.tableQuerryVariable

import com.codefactory.ecommerce.tableDef.{
  CartProductT,
  CartT,
  OrderT,
  ProductT,
  UserT
}
import slick.lifted.TableQuery

trait QueryVariable {

  final val carts = TableQuery[CartT]
  final val orders = TableQuery[OrderT]
  final val products = TableQuery[ProductT]
  final val users = TableQuery[UserT]
  final val cartProduct = TableQuery[CartProductT]

}
