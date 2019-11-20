package com.codefactory.ecommerce.tableQuerry.Cart

import slick.jdbc.MySQLProfile.backend

trait CartDao[T, U[_]] {

  def insertCart(row: T)(implicit db: backend.Database): U[T]

  def updateProduct(id: Int, row: T)(implicit db: backend.Database): U[Int]

  def validateQuantity(id: Int)(implicit db: backend.Database): U[Seq[String]]

}
