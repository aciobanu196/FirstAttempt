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

  def getProductById()(implicit ec: ExecutionContext,
                       id: Int,
                       db: backend.Database) =
    db.run(products.filter(_.id === id).result.headOption)

//  def putProduct()(implicit ec: ExecutionContext, row: Product,
//                   id: Int,
//                   db: backend.Database) =
//    db.run(products.filter(_.id === id).update(row))
//      .map(_ => Some(row)) -NEED TO MAKE CHANGES IMPLICIT VALUE ROW MISSING IN SERVICES

//  def postProduct()(implicit ec: ExecutionContext,
//                    row: Product,
//                    db: backend.Database) =
//    db.run(
//     products returning products
//       .map(_.id) into ((row, id) => row.copy(id = id)) += row)

  def getProductByTypeAsc()(implicit ec: ExecutionContext,
                            db: backend.Database) =
    db.run(products.sortBy(_.productType.asc.nullsFirst).result)

  def getProductByTypeDesc()(implicit ec: ExecutionContext,
                             db: backend.Database) =
    db.run(products.sortBy(_.productType.desc.nullsFirst).result)

}
