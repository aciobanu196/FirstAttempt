package com.codefactory.ecommerce.productservice
import com.codefactory.ecommerce.tableModel.Product
import com.codefactory.ecommerce.tableQuerry.Product.ProductDao
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
import slick.jdbc
import slick.jdbc.MySQLProfile
import slick.jdbc.MySQLProfile.api._
import slick.jdbc.MySQLProfile.backend

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
class ProductService extends QueryVariable with ProductDao[Product, Future] {

  override def selectProductById(id: Int)(
      implicit db: backend.Database): Future[Option[Product]] =
    db.run(products.filter(_.id === id).result.headOption)

  override def updateProducts(id: Int, row: Product)(
      implicit db: backend.Database): Future[Option[Product]] = {
    db.run(products.filter(_.id === id).update(row))
      .map(_ => Some(row))
  }

  override def insertProduct(row: Product)(
      implicit db: backend.Database): Future[Product] =
    db.run(
     products returning products
       .map(_.id) into ((row, id) => row.copy(id = id)) += row)

  override def sortProductByTypeAsc()(
      implicit db: MySQLProfile.backend.Database): Future[Seq[Product]] =
    db.run(products.sortBy(_.productType.asc.nullsFirst).result)

  override def sortProductByTypeDesc()(
      implicit db: jdbc.MySQLProfile.backend.Database): Future[Seq[Product]] =
    db.run(products.sortBy(_.productType.desc.nullsFirst).result)
}
