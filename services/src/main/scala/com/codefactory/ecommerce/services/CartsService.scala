package com.codefactory.ecommerce.services

import com.codefactory.ecommerce.repositories.CartRepository
import com.codefactory.ecommerce.tableModel.Cart
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import scala.concurrent.ExecutionContext

case class CartsService(private val cRepo: CartRepository) extends LazyLogging {

  def postCart()(implicit ec: ExecutionContext,
                 toInsert: Cart,
                 db: backend.Database) = cRepo.postCart()

  def putCart()(implicit ec: ExecutionContext,
                toUpdate: Cart,
                db: backend.Database) = cRepo.putCart()
}
