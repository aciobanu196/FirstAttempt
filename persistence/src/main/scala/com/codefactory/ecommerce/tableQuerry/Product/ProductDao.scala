package com.codefactory.ecommerce.tableQuerry.Product

trait ProductDao[T, U[_]] {

//  def sortProductByType(): U[Seq[Int, String, Int, Int, String]]

  def selectProductById(id: Int): U[Option[T]]

  def updateProducts(id: Int, row: T): U[Option[T]]

  def insertProduct(row: T): U[T]

}
