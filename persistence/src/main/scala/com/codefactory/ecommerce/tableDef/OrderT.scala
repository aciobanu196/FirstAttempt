package com.codefactory.ecommerce.tableDef
import com.codefactory.ecommerce.tableModel.Order
import slick.jdbc.MySQLProfile.api._
import com.codefactory.ecommerce.tableVariables.TableVariables
import com.codefactory.ecommerce.tableQuerryVariable.QuerryVariable

class OrderT(tag: Tag)
    extends Table[Order](tag, "ORDERED")
    with TableVariables
    with QuerryVariable {

  def id = column[Int](orderID, O.PrimaryKey)

  def userID = column[Int](orderUserID)

  def status = column[String](orderStatus)

  def * = (id, userID, status) <> ((Order.apply _).tupled, Order.unapply)

  def user = foreignKey("USER_ORDER_FK", userID, users)(_.id)
}
