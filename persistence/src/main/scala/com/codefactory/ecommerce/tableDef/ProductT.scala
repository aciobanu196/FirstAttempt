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

  def price = column[Int](productPrice)

  def typeID = column[Int](productTypeID)

  def quantity = column[Int](productQuantity)

  def isDeleted = column[Boolean](productDeletion)

  def * =
    (id, name, price, typeID, quantity, isDeleted) <> ((Product.apply _).tupled, Product.unapply)

  def typeP =
    foreignKey("TYPE_FK", typeID, types)(_.id,
                                         onDelete = ForeignKeyAction.Cascade,
                                         onUpdate = ForeignKeyAction.Cascade)

}
