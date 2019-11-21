package com.codefactory.ecommerce.services

import com.codefactory.ecommerce.repositories.ProductRepository

import com.codefactory.ecommerce.repositories.ARepository
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend

import scala.concurrent.ExecutionContext

final case class ProductsService(private val pRepo: ProductRepository) {

  def getProducts()(implicit ec: ExecutionContext, db: backend.Database) =
    pRepo.getProducts

//  def putProduct()(implicit ec: ExecutionContext,
//                   row: Product,
//                   id: Int,
//                   db: backend.Database) = pRepo.putProduct() - SOLVE THE PROBLEM IN REPO SOLVE THE PROBLEM IN SERVICE

  def getProductByTypeAsc()(implicit ec: ExecutionContext,
                            db: backend.Database) = pRepo.getProductByTypeAsc()

  def getProductByTypeDesc()(implicit ec: ExecutionContext,
                             db: backend.Database) =
    pRepo.getProductByTypeDesc()

}
