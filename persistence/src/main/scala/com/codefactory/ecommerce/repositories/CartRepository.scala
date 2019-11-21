package com.codefactory.ecommerce.repositories
import com.codefactory.ecommerce.tableModel.Cart
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext

case class CartRepository() extends LazyLogging with QueryVariable {

  def putInCart()(implicit ec: ExecutionContext,
                  row: Cart,
                  id: Int,
                  db: backend.Database) =
    db.run(
     carts returning carts
       .map(_.id) into ((row, id) => row.copy(id = id)) += row) //SAME PROBLEM TO BE LOOKED AT

  def postInCart()(implicit ec: ExecutionContext,
                   id: Int,
                   row: Cart,
                   db: backend.Database) =
    db.run(carts.filter(_.id === id).update(row))
      .map(_ => Some(row))

  //   val quantityComparisonOk = for {
  //      (p, c) <- products join carts on (_.cartProductID === _.id)
  //      if p.quantity >= c.quantity
  //    } yield c.status
  //    db.run(quantityComparisonOk.result)
  //
  //    val quantityComparisonNotOk = for {
  //      (p, c) <- products join carts on (_.cartProductID === _.id)
  //      if p.quantity < c.quantity
  //    } yield c.status
  //    db.run(quantityComparisonNotOk.result) -NO LONGER APPLICABLE KEPT AS A PLACEHOLDER

}
