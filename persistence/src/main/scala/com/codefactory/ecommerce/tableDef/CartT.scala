package com.codefactory.ecommerce.tableDef
import com.codefactory.ecommerce.tableModel.Cart
import slick.jdbc.MySQLProfile.api._
import com.codefactory.ecommerce.tableVariables.TableVariables
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable

class CartT(tag: Tag)
    extends Table[Cart](tag, "CART")
    with TableVariables
    with QueryVariable {

  def id = column[Int](cartID, O.PrimaryKey, O.AutoInc)

  def quantity = column[Int](cartProductQuantity)

  def status = column[String](cartProductStatus)

  def userID = column[Int](userIDcart)

  def total = column[Float](cartTotal)

  def * =
    (id, quantity, status, userID, total) <> ((Cart.apply _).tupled, Cart.unapply)

  def user =
    foreignKey("USERS_FK", userID, users)(_.id,
                                          onDelete = ForeignKeyAction.Cascade,
                                          onUpdate = ForeignKeyAction.Cascade)
}
