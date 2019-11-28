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

  def postProduct(createProduct: Product)(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) = pRepo.postProduct(createProduct)

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

  // Testing to see how it works this is a bad idea

//  def partialUpdate(
//      id: Int,
//      name: Option[String],
//      price: Option[Float],
//      productType: Option[String],
//      quantity: Option[Int],
//      isDeleted: Option[Int]
//  )(
//      implicit ec: ExecutionContext,
//      db: backend.Database
//  ) = pRepo.partialUpdate(id, name, price, productType, quantity, isDeleted)
}
