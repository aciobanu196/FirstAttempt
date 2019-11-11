package Services
import scala.concurrent.{ExecutionContext, Future}
import DBrelated.Products
class ShopService (val databaseService: DatabaseService)(implicit executionContext: ExecutionContext) {
    import databaseService._
    import databaseService.driver.api_
    val products = TableQuery[daoType.ShopT]

    def getProducts: Future[Seq[Products]] = db.run(products.result)

    def getProductById(id: Long): Future[Option[Products]] = db.run(products.filter(_.id === id).result.headOption)

    def getProductsByType(product_name: String): Future[Seq[Products]] = db.run(products.filter(_.productName === product_name).result)

    def createProduct(product: Products): Future[Products] = db.run(products returning products.map(_.id) into ((product, id) => product.copy(id=Some(id))) += product)

    def update(id: Long, toUpdate: Products): Future[Option[Products]] = getProductById(id).flatMap {
      case Some(product) =>
        val updateProducts = Products(product.id, toUpdate.product_name, toUpdate.product_price, toUpdate.product_type)
        db.run(products.filter(_.id === id).update(updateProducts)).map(_ => Some(updateProducts))
      case None => Future.successful(None)
    }

    def deleteHotel(id: Long):Future[Int] = db.run(products.filter(_.id === id).delete)
}
