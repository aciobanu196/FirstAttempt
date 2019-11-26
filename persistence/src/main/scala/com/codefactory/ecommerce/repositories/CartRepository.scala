package com.codefactory.ecommerce.repositories
import com.codefactory.ecommerce.httpModel.ProductsAndQuantities
import com.codefactory.ecommerce.tableModel.Cart
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext

case class CartRepository() extends LazyLogging with QueryVariable {

  def postCart(userId: Int, productsAndQuantities: List[ProductsAndQuantities])(
      implicit ec: ExecutionContext,
      db: backend.Database
  ) = db.run {
    (carts.map(c => (c.productID, c.quantity, c.userID, c.status, c.total))
      returning carts.map(_.id)
      into (
          (
              productQ,
              id
          ) =>
            Cart(
             id,
             productID = productQ._1,
             quantity = productQ._2,
             userID = productQ._3
            )
        ) ++= productsAndQuantities.iterator
      .map { it =>
        (it.product, it.quantity, userId, "pending", 0f)
      }
      .to(Iterable))
  }

  def putCart()(
      implicit ec: ExecutionContext,
      toUpdate: Cart,
      db: backend.Database
  ) = {
    db.run(
     carts
       .filter(_.id === toUpdate.id)
       .map(carts => (carts.quantity, carts.productID))
       .update(toUpdate.quantity, toUpdate.productID)
    )
  }

}
