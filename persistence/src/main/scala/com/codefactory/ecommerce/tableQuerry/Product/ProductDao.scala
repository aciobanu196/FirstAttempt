package com.codefactory.ecommerce.tableQuerry.Product

import slick.jdbc.MySQLProfile.backend

trait ProductDao[T, U[_]] {

//  def sortProductByType(): U[Seq[Int, String, Int, Int, String]]

  def selectProductById(id: Int)(implicit db: backend.Database): U[Option[T]]

  def updateProducts(id: Int, row: T)(implicit db: backend.Database): U[Option[T]]

  def insertProduct(row: T)(implicit db: backend.Database): U[T]

}
