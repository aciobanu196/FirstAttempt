package com.codefactory.ecommerce.tableDef
import com.codefactory.ecommerce.tableModel.User
import slick.jdbc.MySQLProfile.api._
import com.codefactory.ecommerce.tableVariables.TableVariables
import com.codefactory.ecommerce.tableQuerryVariable.QuerryVariable

class UserT(tag: Tag)
    extends Table[User](tag, "USERS")
    with TableVariables
    with QuerryVariable {

  def id = column[Int](usersID, O.PrimaryKey, O.AutoInc)

  def name = column[String](userName)

  def email = column[String](userEmail)

  def bankID = column[Int](userBankID)

  def *    = (id, name, email, bankID) <> ((User.apply _).tupled, User.unapply)
  def bank = foreignKey("BANK_FK", bankID, banks)(_.id)
}
