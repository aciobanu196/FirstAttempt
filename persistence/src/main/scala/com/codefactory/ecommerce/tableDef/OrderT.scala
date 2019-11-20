package com.codefactory.ecommerce.tableDef
import com.codefactory.ecommerce.tableModel.Order
import slick.jdbc.MySQLProfile.api._
import com.codefactory.ecommerce.tableVariables.TableVariables
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable

class OrderT(tag: Tag)
    extends Table[Order](tag, "ORDERED")
    with TableVariables
    with QueryVariable {

  def id = column[Int](orderID, O.PrimaryKey)

  def userID = column[Int](orderUserID)

  def status = column[String](orderStatus)

  def orderCartID = column[Int](orderCartId)

  def * =
    (id, userID, status, orderCartID) <> ((Order.apply _).tupled, Order.unapply)

  def cart =
    foreignKey("CART_ORDER_FK", orderCartID, carts)(
     _.id,
     onDelete = ForeignKeyAction.Cascade,
     onUpdate = ForeignKeyAction.Cascade)
}
