//package Services
//import scala.concurrent.{ExecutionContext, Future}
//import DBrelated.Products
//import db.DAO
//import slick.lifted.TableQuery
////Needs more work - Dependencies to be resolved , add connection to DB, then... theoretically speaking from the tutorials that I watched this should be used in the path "declaration" so when it calls the endpoint a certain querry is run in order to retrieve the information
//// Only thing available here are as follow :
//// - return all the products from the DB
//// - return specific product by ID, Example http://localhost:8080/products/1 should return the first product in the table
////    val products = TableQuery[Products]
////
////    def getProducts: Future[Seq[Products]] = db.run(products.result)
////
////    def getProductById(id: Long): Future[Option[Products]] = db.run(products.filter(_.id === id).result.headOption)
////
////    def getProductsByType(product_name: String): Future[Seq[Products]] = db.run(products.filter(_.productName === product_name).result)
////
////    def createProduct(product: Products): Future[Products] = db.run(products returning products.map(_.id) into ((product, id) => product.copy(id=Some(id))) += product)
////
////    def update(id: Long, toUpdate: Products): Future[Option[Products]] = getProductById(id).flatMap {
////      case Some(product) =>
////        val updateProducts = Products(product.id, toUpdate.product_name, toUpdate.product_price, toUpdate.product_type)
////        db.run(products.filter(_.id === id).update(updateProducts)).map(_ => Some(updateProducts))
////      case None => Future.successful(None)
////    }
////
////    def deleteProduct(id: Long):Future[Int] = db.run(products.filter(_.id === id).delete)
////}

//PLACEHOLDER