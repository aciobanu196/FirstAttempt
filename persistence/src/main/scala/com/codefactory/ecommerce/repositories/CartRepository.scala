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

//  def patchCart(
//      id: Int,
//      quantity: Option[Int]
//  )(implicit ec: ExecutionContext, db: backend.Database) = {
//    db.run(
//     carts.filter(_.id === id)(quantity) match {
//       case (Some(quantity)) =>
//     }
//    )
//  }

//  def patchPerson(name: Option[String], age: Option[Int]) = {
//    val query = people.filter(_.name === "M Odersky")
//    (name, age) match {
//      case (Some(name), Some(age)) =>
//        query.map(p => (p.name, p.age)).update(name, age)
//      case (Some(name), None) =>
//        query.map(p => p.name).update(name)
//      case (None, Some(age)) =>
//        query.map(p => p.age).update(age)
//    }
//  }

//  def patchCart(userId: Int, quantity: Cart)(
//      implicit ec: ExecutionContext,
//      db: backend.Database
//  ) = {
//    db.run(
//     carts
//       .filter(_.userID === userId)
//       .map(_.quantity)
//       .update(quantity.quantity)
//    )
//  }

//  id: Int,
//  productID: Int,
//  quantity: Int,
//  userID: Int,
//  status: String = "pending",
//  total: Float = 0

//  def patchChart(userId: Int, quantity: Option[Int])(
//      implicit ec: ExecutionContext,
//      db: backend.Database
//  ) = {
//
//    val SelectQ = carts.filter(_.id === userId)
//    val query = SelectQ.result.head.flatMap { toPatch =>
//      SelectQ.update(toPatch.patch)
//
//    }

//    def patch(name: Option[String], state: Option[State], price: Option[Int]): Data {
//      this.copy(name = name.getOrElse(this.name), ...)
//    db.run(
//     carts.filter(_.userID===userId).result.head.flatMap(data =>
//     .update())
//
//    )
//  def partialUpdate(id: Int, name: Option[String], login: Option[String]): Future[Int] = {
  //    val selectQ = users.filter(_.id === id)
  //
  //    val query = selectQ.result.head.flatMap { data =>
  //      selectQ.update(data.patch(name, login))
  //    }
  //
  //    db.run(query)
  //  }

}
