//package com.codefactory.ecommerce.tableQuerry
//
//import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
//import com.codefactory.ecommerce.tableVariables.TableVariables
//import slick.jdbc.MySQLProfile.api._
//
//import scala.concurrent.Await
//import scala.concurrent.duration.Duration
//
//object TestingQuerries extends App with QueryVariable with TableVariables {
//
//  val db = Database.forConfig("mydb")
//
//  val quantityComparisonOk = for {
//    (p, c) <- products join carts on (_.cartProductID === _.id)
//    if p.quantity >= c.quantity
//  } yield c.status
//
//  val result = db.run(quantityComparisonOk.result)
//
//  Await.result(result, Duration.Inf)
//
//  print(result)
//
//  val quantityComparisonNotOk = for {
//    (p, c) <- products join carts on (_.cartProductID === _.id)
//    if p.quantity < c.quantity
//  } yield c.status
//
//  val result2 = db.run(quantityComparisonNotOk.result)
//
//  Await.result(result2, Duration.Inf)
//
//  print(result2)
//
//}
////
////  //returnează produsele valabile filtrate după tip
////  val productsWithType = for {
////    (p, t) <- products join types on (_.typeID === _.id)
////    if p.quantity > 0
////  } yield (p.id, p.name, p.price, p.quantity, t.tname)
////
////  val actionDesc = productsWithType.sortBy(_._5.desc).result
////  val actionAsc = productsWithType.sortBy(_._5.asc).result
////  val resultDesc = db.run(actionDesc)
////  val resultAsc = db.run(actionAsc)
////  Await.result(resultDesc, Duration.Inf)
////  Await.result(resultAsc, Duration.Inf)
////  resultDesc.foreach(println) // To check if it works - need to write tests - TO BE DELETED
////  resultAsc.foreach(println) // To check if it works - need to write tests - TO BE DELETED
////
////  // I saw that you can encapsulate everything and sort by something specific , but how can you sort by both if you do not have 2 distinct values
////
////  // Adding products to cart the result will be as follows:
////  val productToCart = for {
////    (c, p) <- carts join products on (_.productID === _.id)
////  } yield
////    (c.id,
////      c.quantity,
////      c.status,
////      c.quantity,
////      c.total,
////      p.id,
////      p.name,
////      p.price,
////      p.typeID)
////
////  // Bring balance for a specific user
////
////  val bringBalanceForUser = for {
////    (u, b) <- users join banks on (_.bankID === _.id)
////  } yield (u.id, b.balance) // Might need some extra work
////  val action2 = bringBalanceForUser.result
////  val result2 = db.run(action2)
////  Await.result(result2, Duration.Inf)
////  result2.foreach(println)
////
////  // Check if the quantity in the cart is lower or equal than the quantity in the products - THIS IS NOT OK
////  val StatusRetrievalLower = for {
////    (c, p) <- carts join products on (_.productID === _.id)
////    if c.quantity <= p.quantity
////  } yield c.status // - TO BE DELETED
////
////  //  val updateStatusRetrievalLower = StatusRetrievalLower.update("In stock")
////
////  // Check if the quantity in the cart is higher than the quantity in the products - THIS IS NOT OK
////  val StatusRetrievalHigher = for {
////    (c, p) <- carts join products on (_.productID === _.id)
////    if c.quantity > p.quantity
////  } yield c.status // TO BE DELETED
////
////  //POST /order/{accountsId} BODY [{"productId":1, "quantity": 10},{"productId":2, "quantity": 1}]
////  //path accountid | body lista de productId cu cantitati
////  //luam produsele din db
////  //validam cantitatile
////  //validam balanta
////  //creem carts
////  //creem ordered
////  //modificam balanta clientului
////  //updatam status la ordered
////
////  //  val updateStatusRetrievalHigher = StatusRetrievalHigher.update("Out of stock")
////
////  // HTTP methods begin
////  //Get product by ID
////  def getProductById(id: Int): Future[Option[Product]] =
////    db.run(products.filter(_.id === id).result.headOption)
////
////  // Add one product into DB -echivalent la POST
////  def addProductinList(product: Product): Future[Product] =
////    db.run(
////      products returning products
////        .map(_.id) into ((product, id) => product.copy(id = id)) += product)
////
////  // Update product - echivalent la PUT
////  def updateProduct(id: Int, Update: Product): Future[Option[Product]] = {
////    val updatedProduct =
////      Product(Update.id,
////        Update.name,
////        Update.price,
////        Update.typeID,
////        Update.quantity)
////    db.run(products.filter(_.id === id).update(updatedProduct))
////      .map(_ => Some(updatedProduct))
////  }
////  // DELETE
////  def deleteProduct(id: Int): Future[Int] =
////    db.run(products.filter(_.id === id).delete)
////
////  // POST TO CART
////  def addProductToCart(cart: Cart): Future[Cart] =
////    db.run(
////      carts returning carts
////        .map(_.id) into ((cart, id) => cart.copy(id = id)) += cart)
////
////  //PUT product in CART
////
////  //  def updateCart(id:Int,Update:Cart):Future[Option[Cart]] = {
////  //    val updatedCart = Cart(Update.productID,Update.quantity,_,_,_)
////  //    db.run(carts.filter(_.id===id).update(updatedCart)).map(_=>Some(updatedCart))
////  //
////  //  }
////  // HTTP methods End
////  //  val RetrieveQuantityFromCart = for {
////  //    (c, p) <- carts join products on (_.productID === _.id)
////  //  } yield multiply(c.quantity, p.price)
////  //
////  //  val totalCart = RetrieveQuantityFromCart.sum
////  //
////  //  val multiply = SimpleBinaryOperator.apply[Int]("*")
////
////  //  def updateProduct(id:Int,name:String,price:Int,typeId:Int,quantity:Int) =
////  //    db.run(products.filter(_.id === id).update(id,name,price,typeId,quantity)
////
////}
