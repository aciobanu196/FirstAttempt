package com.codefactory.ecommerce.services

import com.codefactory.ecommerce.httpModel.ProductsAndQuantities
import com.codefactory.ecommerce.repositories.CartRepository
import com.codefactory.ecommerce.tableModel.Cart
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend

import scala.concurrent.ExecutionContext

case class CartsService(private val cRepo: CartRepository) extends LazyLogging {

  def postCart(userId: Int, productsAndQuantities: List[ProductsAndQuantities])(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) = cRepo.postCart(userId, productsAndQuantities)
}
