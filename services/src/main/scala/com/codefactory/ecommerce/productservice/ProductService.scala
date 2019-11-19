package com.codefactory.ecommerce.productservice
import com.codefactory.ecommerce.tableModel.Product
import com.codefactory.ecommerce.tableQuerry.Product.ProductDao
import com.codefactory.ecommerce.tableQuerryVariable.QuerryVariable
import slick.jdbc.MySQLProfile.api._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
class ProductService extends QuerryVariable with ProductDao[Product, Future] {

//  override def sortProductByType() = {
//
//    val productsWithType = for {
//      (p, t) <- products join types on (_.typeID === _.id)
//      if p.quantity > 0
//    } yield (p.id, p.name, p.price, p.quantity, t.tname)
//
//    val actionDesc = productsWithType.sortBy(_._5.desc).result
//    val actionAsc = productsWithType.sortBy(_._5.asc).result
//    db.run(actionDesc)
//    db.run(actionAsc)
//  } - TO BE CHANGED otherwise you will have an error when using Future ...this is fun NOT - Change

  override def selectProductById(id: Int): Future[Option[Product]] =
    db.run(products.filter(_.id === id).result.headOption)

  override def updateProducts(id: Int,
                              row: Product): Future[Option[Product]] = {
    db.run(products.filter(_.id === id).update(row))
      .map(_ => Some(row))
  }

  override def insertProduct(row: Product): Future[Product] =
    db.run(
     products returning products
       .map(_.id) into ((row, id) => row.copy(id = id)) += row)

}
