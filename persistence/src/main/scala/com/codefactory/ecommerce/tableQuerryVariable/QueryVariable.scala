package com.codefactory.ecommerce.tableQuerryVariable

import com.codefactory.ecommerce.tableDef.{CartT, OrderT, ProductT, UserT}
import slick.lifted.TableQuery

import slick.jdbc.MySQLProfile.api._

trait QueryVariable {

  final val carts = TableQuery[CartT]
  final val orders = TableQuery[OrderT]
  final val products = TableQuery[ProductT]
  final val users = TableQuery[UserT]

}
