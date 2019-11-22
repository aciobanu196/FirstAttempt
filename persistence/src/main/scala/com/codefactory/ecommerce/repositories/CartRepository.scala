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
//      into ((productQ, id) =>
//              Cart(id, productQ._1, productQ._2)) += (product, quantity))
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
