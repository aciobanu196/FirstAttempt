package com.codefactory.ecommerce.services

import com.codefactory.ecommerce.repositories.CartRepository
import com.codefactory.ecommerce.tableModel.Cart
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import scala.concurrent.ExecutionContext

case class CartsService(private val cRepo: CartRepository) extends LazyLogging {

  def putCart()(implicit ec: ExecutionContext,
                row: Cart,
                id: Int,
                db: backend.Database) =
    cRepo
      .putCart() //Needs changes needs to be able to edit product id and quantity

  def postCart()(implicit ec: ExecutionContext,
                 row: Cart,
                 id: Int,
                 db: backend.Database) =
    cRepo.postCart() //Needs to be changed to post only product id and quantity

}
