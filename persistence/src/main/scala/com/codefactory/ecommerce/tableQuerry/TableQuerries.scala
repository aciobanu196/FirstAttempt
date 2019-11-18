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

  //returnează produsele valabile filtrate după tip
  val productsWithType = for {
    (p, t) <- products join types on (_.typeID === _.id)
  } yield (p.id, p.name, p.price, p.quantity, t.tname)

  val actionDesc = productsWithType.sortBy(_._5.desc).result
  val actionAsc  = productsWithType.sortBy(_._5.asc).result
  val resultDesc = db.run(actionDesc) // Part of services
  val resultAsc  = db.run(actionAsc) // Part of services
  Await.result(resultDesc, Duration.Inf)
  Await.result(resultAsc, Duration.Inf)
  resultDesc.foreach(println) // To check if it works - need to write tests - TO BE DELETED
  resultAsc.foreach(println)  // To check if it works - need to write tests - TO BE DELETED

  // I saw that you can encapsulate everything and sort by something specific , but how can you sort by both if you do not have 2 distinct values

  // Adding products to cart the result will be as follows:
  val productToCart = for {
    (c, p) <- carts join products on (_.productID === _.id)
  } yield
    (c.id, c.quantity, c.status, c.quantity, c.total, p.id, p.name, p.price)

  // Bring balance for a specific user

  val bringBalanceForUser = for {
    (u, b) <- users join banks on (_.bankID === _.id)
  } yield (u.id, b.balance) // Might need some extra work
  val action2 = bringBalanceForUser.result
  val result2 = db.run(action2)
  Await.result(result2, Duration.Inf)
  result2.foreach(println)

  // Check if the quantity in the cart is lower or equal than the quantity in the products - THIS IS NOT OK
  val StatusRetrievalLower = for {
    (c, p) <- carts join products on (_.productID === _.id)
    if c.quantity <= p.quantity
  } yield c.status

//  val updateStatusRetrievalLower = StatusRetrievalLower.update("In stock")

  // Check if the quantity in the cart is higher than the quantity in the products - THIS IS NOT OK
  val StatusRetrievalHigher = for {
    (c, p) <- carts join products on (_.productID === _.id)
    if c.quantity > p.quantity
  } yield c.status

//  val updateStatusRetrievalHigher = StatusRetrievalHigher.update("Out of stock")

  //Get product by ID
  def getProductById(id: Int): Future[Option[Product]] =
    db.run(products.filter(_.id === id).result.headOption)

  // Add one product into DB
  def addProduct(product: Product): Future[Product] =
    db.run(
      products returning products
        .map(_.id) into ((product, id) => product.copy(id = id)) += product)

}
