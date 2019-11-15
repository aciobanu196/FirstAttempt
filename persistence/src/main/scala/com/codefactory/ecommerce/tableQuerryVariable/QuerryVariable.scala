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

trait QuerryVariable {

  final val banks    = TableQuery[BankT]
  final val carts    = TableQuery[CartT]
  final val orders   = TableQuery[OrderT]
  final val products = TableQuery[ProductT]
  final val types    = TableQuery[TypeT]
  final val users    = TableQuery[UserT]
}
