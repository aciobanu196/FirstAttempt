package com.codefactory.ecommerce.cartservice
import scala.concurrent.ExecutionContext.Implicits.global
import com.codefactory.ecommerce.tableModel.Cart
import com.codefactory.ecommerce.tableQuerry.Cart.CartDao
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
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

  override def updateProduct(id: Int, row: Cart)(
      implicit db: backend.Database): Future[Int] = ???

//  override def validateQuantity(id: Int)(implicit db: backend.Database): Future[Seq[String]] = {
//    val statusEvaluationOK = for {
//      (c, p) <- carts join products on (_.productID === _.id)
//      if c.quantity <= p.quantity
//    } yield c.status
//
//    val result = statusEvaluationOK.result
//    db.run(result)
//
//    val statusEvaluationNotOK = for {
//      (c, p) <- carts join products on (_.productID === _.id)
//      if c.quantity > p.quantity
//    } yield c.status
//    val result2 = statusEvaluationNotOK.result
//    db.run(result2)
//  }
  override def validateQuantity(id: Int)(
      implicit db: MySQLProfile.backend.Database): Future[Seq[String]] = ???
}
