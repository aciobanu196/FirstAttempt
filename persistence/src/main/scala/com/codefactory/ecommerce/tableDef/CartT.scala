package com.codefactory.ecommerce.tableDef
import com.codefactory.ecommerce.tableModel.Cart
import slick.jdbc.MySQLProfile.api._
import com.codefactory.ecommerce.tableVariables.TableVariables
import com.codefactory.ecommerce.tableQuerryVariable.QuerryVariable

class CartT(tag: Tag)
    extends Table[Cart](tag, "CART")
    with TableVariables
    with QuerryVariable {

  def id        = column[Int](cartID, O.PrimaryKey, O.AutoInc)
  def productID = column[Int](cartProductID)

  def quantity = column[Int](cartProductQuantity)

  def status = column[String](cartProductStatus)

  def total = column[Int](cartTotal)

  def * =
    (id, productID, quantity, status, total) <> ((Cart.apply _).tupled, Cart.unapply)

  def product = foreignKey("PRODUCT_FK", productID, products)(_.id)
}
