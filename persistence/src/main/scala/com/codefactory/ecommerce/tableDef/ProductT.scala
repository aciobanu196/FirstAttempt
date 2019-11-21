package com.codefactory.ecommerce.tableDef
import com.codefactory.ecommerce.tableModel.Product
import slick.jdbc.MySQLProfile.api._
import com.codefactory.ecommerce.tableVariables.TableVariables
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable

class ProductT(tag: Tag)
    extends Table[Product](tag, "PRODUCTS")
    with TableVariables
    with QueryVariable {
  def id = column[Int](productsID, O.PrimaryKey)

  def name = column[String](productName)

  def price = column[Float](productPrice)

  def productType = column[String](productTypeName)

  def quantity = column[Int](productQuantity)

  def isDeleted = column[Boolean](productDeletion)

  def * =
    (id, name, price, productType, quantity, isDeleted) <> ((Product.apply _).tupled, Product.unapply)

}
