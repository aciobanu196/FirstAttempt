package com.codefactory.ecommerce.cartservice
import scala.concurrent.ExecutionContext.Implicits.global
import com.codefactory.ecommerce.tableModel.Cart
import com.codefactory.ecommerce.tableQuerry.Cart.CartDao
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
import slick.jdbc
import slick.jdbc.MySQLProfile
import slick.jdbc.MySQLProfile.api._
import slick.jdbc.MySQLProfile.backend

import scala.concurrent.Future

class CartService extends QueryVariable with CartDao[Cart, Future] {

  override def insertCart(row: Cart)(
      implicit db: backend.Database): Future[Cart] =
    db.run(
     carts returning carts
       .map(_.id) into ((row, id) => row.copy(id = id)) += row)

//  override def validateQuantity(id: Int)(
//      implicit db: jdbc.MySQLProfile.backend.Database): Future[Seq[String]] = {
//    val quantityComparisonOk = for {
//      (p, c) <- products join carts on (_.cartProductID === _.id)
//      if p.quantity >= c.quantity
//    } yield c.status
//    db.run(quantityComparisonOk.result)
//
//    val quantityComparisonNotOk = for {
//      (p, c) <- products join carts on (_.cartProductID === _.id)
//      if p.quantity < c.quantity
//    } yield c.status
//    db.run(quantityComparisonNotOk.result)
//  } - TO BE CHANGED BASED ON FUTURE IMPLEMENTATION

  override def updateProduct(id: Int, row: Cart)(
      implicit db: _root_.slick.jdbc.MySQLProfile.backend.DatabaseDef)
    : Future[Option[Cart]] =
    db.run(carts.filter(_.id === id).update(row))
      .map(_ => Some(row))
}
