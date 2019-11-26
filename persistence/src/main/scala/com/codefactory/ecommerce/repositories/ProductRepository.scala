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
  ) = db.run(
   products.filter(_.id === id).update(pUpdate)
  )

  def postProduct(createProduct: Product)(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) =
    db.run(
     products returning products
       .map(_.id) into ((createProduct, id) => createProduct.copy(id = id)) += createProduct
    )

//
//  val userWithId =
//    (users returning users.map(_.id)
//      into ((user,id) => user.copy(id=Some(id)))
//      ) += User(None, "Stefan", "Zeiger")

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
