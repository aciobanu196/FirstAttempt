package com.codefactory.ecommerce.tableDef
import com.codefactory.ecommerce.tableModel.User
import slick.jdbc.MySQLProfile.api._
import com.codefactory.ecommerce.tableVariables.TableVariables
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable

class UserT(tag: Tag)
    extends Table[User](tag, "USERS")
    with TableVariables
    with QueryVariable {

  def id = column[Int](usersID, O.PrimaryKey, O.AutoInc)

  def name = column[String](userName)

  def email = column[String](userEmail)

  def bankBalance = column[Float](userBankBalance)

  def * =
    (id, name, email, bankBalance) <> ((User.apply _).tupled, User.unapply)
}
