package com.codefactory.ecommerce.tableQuerry
import com.codefactory.ecommerce.tableDef.ProductT
import com.codefactory.ecommerce.tableModel.{Product, User}

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global
import com.codefactory.ecommerce.tableQuerryVariable.QuerryVariable
import com.codefactory.ecommerce.tableVariables.TableVariables
import slick.jdbc.MySQLProfile.api._

object TableQuerries extends App with QuerryVariable with TableVariables {

  val db = Database.forConfig("mydb")

  // This one will be used to return the products by type
  val productsWithType = for {
    (p, t) <- products join types on (_.typeID === _.id)
  } yield (p.id, p.name, p.price, p.quantity, t.tname)

  val actionDesc = productsWithType.sortBy(_._5.desc).result
  val actionAsc  = productsWithType.sortBy(_._5.asc).result
  val resultDesc = db.run(actionDesc)
  val resultAsc  = db.run(actionAsc)
  Await.result(resultDesc, Duration.Inf)
  Await.result(resultAsc, Duration.Inf)
  resultDesc.foreach(println)
  resultAsc.foreach(println)

  // Don't know yet if this is exactly how it will be used/ need to further think at it - Need to add up the total
//  val productToCart = for {
//    (c, p) <- carts join products on (_.productID === _.id)
//  } yield (c.id, c.quantity, c.status, c.quantity, p.price)
//
//  // Join to bring the balance for a specific user
//
//  val bringBalanceForUser = for {
//    (u, b) <- users join banks on (_.bankID === _.id)
//  } yield
//    (u.id, b.balance) // Might need some extra work - I mean I need that the balance for each individual user to be returned
//  val action2 = bringBalanceForUser.result
//  val result2 = db.run(action2)
//  Await.result(result2, Duration.Inf)
//  result2.foreach(println)

//  val userId =
//    (users returning users.map(_.id)) += User(3,
//                                              "Alin Ciobanu 2",
//                                              "alin.ciobanu2test@gmail.com",
//                                              3)
//
//  val result3 = db.run(userId)
//  Await.result(result3, Duration.Inf)

}
