package com.codefactory.ecommerce.repositories

import com.codefactory.ecommerce.tableModel.Product
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext

final case class ProductRepository() extends LazyLogging with QueryVariable {

  def getProducts()(implicit ec: ExecutionContext, db: backend.Database) =
    db.run {
      products.result
    }

  def getProductById(id: Int)(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) =
    db.run(products.filter(_.id === id).result.headOption)

  def putProduct(id: Int, pUpdate: Product)(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) =
    db.run(products.filter(_.id === id).update(pUpdate))
      .map(_ => Some(pUpdate))

  def postProduct()(
      implicit ec: ExecutionContext,
      row: Product,
      db: backend.Database
  ) =
    db.run(
     products returning products
       .map(_.id) into ((row, id) => row.copy(id = id)) += row
    )

  def getProductByTypeAsc()(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) =
    db.run(products.sortBy(_.productType.asc.nullsFirst).result)

  def getProductByTypeDesc()(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) =
    db.run(products.sortBy(_.productType.desc.nullsFirst).result)

}
