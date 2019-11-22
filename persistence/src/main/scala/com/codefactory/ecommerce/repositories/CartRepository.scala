package com.codefactory.ecommerce.repositories
import com.codefactory.ecommerce.tableModel.Cart
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext

case class CartRepository() extends LazyLogging with QueryVariable {

  //PROPER WAY OF IMPLEMENTATION - HAS AN ERROR, NEED TO CHECK
//  def postCart()(implicit ec: ExecutionContext,
//                 product: Int,
//                 quantity: Int,
//                 db: backend.Database) = db.run {
//    (carts.map(c => (c.productID, c.quantity))
//      returning carts.map(_.id)
//      into ((productQ, id) => Cart(id, productQ._1, productQ._2)) += (product, quantity))
//  }

  def putCart()(implicit ec: ExecutionContext,
                toUpdate: Cart,
                db: backend.Database) = {
    db.run(
     carts
       .filter(_.id === toUpdate.id)
       .map(carts => (carts.quantity, carts.productID))
       .update(toUpdate.quantity, toUpdate.productID))
  }

}
