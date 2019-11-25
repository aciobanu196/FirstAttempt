package com.codefactory.ecommerce.repositories
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext
import scala.util.control.Exception

final case class OrderRepository() extends LazyLogging with QueryVariable {

  def orderProducts()(implicit ec: ExecutionContext, db: backend.Database) = {

    val compareQuantityOk = for {
      (c, p) <- carts join products on (_.productID === _.id)
      if c.quantity <= p.quantity
    } yield c.status

//    db.run(compareQuantityOk.update("In Stock"))

    val compareQuantityNotOk = for {
      (c, p) <- carts join products on (_.productID === _.id)
      if c.quantity > p.quantity
    } yield c.status

//    db.run(compareQuantityNotOk.update("Out of stock"))

    val compareBalanceOk = for {
      ((o, u), c) <- (orders join users on (_.userID === _.id)) join carts on (_._1.orderCartID === _.id)
      if c.total <= u.bankBalance
    } yield o.status

//    db.run(compareBalanceOk.update("Approved"))

    val compareBalanceNotOk = for {
      ((o, u), c) <- (orders join users on (_.userID === _.id)) join carts on (_._1.orderCartID === _.id)
      if c.total > u.bankBalance
    } yield o.status

//    db.run(compareBalanceNotOk.update("Transaction Denied/Insufficient Funds"))

    val obtainTotalInCart = for {
      (c, u) <- carts join users on (_.userID === _.id)
    } yield c.total

    val obtainBalanceforUser = for {
      (c, u) <- carts join users on (_.userID === _.id)
    } yield u.bankBalance

    val totalSum = db.run(obtainTotalInCart.result)
    val totalBalance = db.run(obtainBalanceforUser.result)

  }

}
