package com.codefactory.ecommerce.services
import com.codefactory.ecommerce.tableModel.Product
import com.codefactory.ecommerce.repositories.ProductRepository
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend

import scala.concurrent.ExecutionContext

final case class ProductsService(private val pRepo: ProductRepository)
    extends LazyLogging {

  def getProducts()(implicit ec: ExecutionContext, db: backend.Database) =
    pRepo.getProducts

  def putProduct(id: Int, pUpdate: Product)(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) = pRepo.putProduct(id, pUpdate)

  def postProduct(
      implicit ec: ExecutionContext,
      row: Product,
      db: backend.Database
  ) = pRepo.postProduct()

  def getProductByTypeAsc()(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) = pRepo.getProductByTypeAsc()

  def getProductByTypeDesc()(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) =
    pRepo.getProductByTypeDesc()

  def getProductById(id: Int)(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) = pRepo.getProductById(id)
}
