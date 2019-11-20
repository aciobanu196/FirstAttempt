package com.codefactory.ecommerce.tableQuerry.Product

import slick.jdbc.MySQLProfile.backend

trait ProductDao[T, U[_]] {

  def sortProductByTypeAsc()(implicit db: backend.Database): U[Seq[T]]

  def selectProductById(id: Int)(implicit db: backend.Database): U[Option[T]]

  def updateProducts(id: Int, row: T)(
      implicit db: backend.Database): U[Option[T]]

  def insertProduct(row: T)(implicit db: backend.Database): U[T]

  def sortProductByTypeDesc()(implicit db: backend.Database): U[Seq[T]]

}
