package com.codefactory.ecommerce.repositories
import com.codefactory.ecommerce.tableModel.Cart
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext

case class CartRepository() extends LazyLogging with QueryVariable {

  def postCart()(implicit ec: ExecutionContext,
                 toInsert: Cart,
                 db: backend.Database) =
    db.run(
     carts returning carts
       .map(c => (c.productID, c.quantity)) += toInsert)

  def putCart()(implicit ec: ExecutionContext,
                toUpdate: Cart,
                db: backend.Database) = {
    db.run(
     carts
       .filter(_.id === toUpdate.id)
       .map(carts => (carts.quantity, carts.productID))
       .update(toUpdate.quantity, toUpdate.productID))
  }

  // Needs to be changed to post only product Id and quantity
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
//  case Some(hotel) => {
//    val updatedHotel = Hotel(hotel.id, toUpdate.name, toUpdate.address, toUpdate.zip)
//    db.run(hotels.filter(_.id === id).update(updatedHotel)).map(_ => Some(updatedHotel))
//  }
}
