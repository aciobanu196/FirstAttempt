package com.codefactory.ecommerce.tableQuerry.Cart

trait CartDao[T, U[_]] {

  def insertCart(row: T): U[T]

  def updateProduct(id: Int, row: T): U[Int]

  def validateQuantity(id: Int): U[Seq[String]]

}
