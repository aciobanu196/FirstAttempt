package com.codefactory.ecommerce.cartservice
import scala.concurrent.ExecutionContext.Implicits.global
import com.codefactory.ecommerce.tableModel.Cart
import com.codefactory.ecommerce.tableQuerry.Cart.CartDao
import com.codefactory.ecommerce.tableQuerryVariable.QuerryVariable
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.Future

class CartService extends QuerryVariable with CartDao[Cart, Future] {

  override def insertCart(row: Cart): Future[Cart] =
    db.run(
     carts returning carts
       .map(_.id) into ((row, id) => row.copy(id = id)) += row)

  override def updateProduct(id: Int, row: Cart): Future[Int] = ???

  override def validateQuantity(id: Int): Future[Seq[String]] = {
    val statusEvaluationOK = for {
      (c, p) <- carts join products on (_.productID === _.id)
      if c.quantity <= p.quantity
    } yield c.status

    val result = statusEvaluationOK.result
    db.run(result)

    val statusEvaluationNotOK = for {
      (c, p) <- carts join products on (_.productID === _.id)
      if c.quantity > p.quantity
    } yield c.status
    val result2 = statusEvaluationNotOK.result
    db.run(result2)
  }

}
