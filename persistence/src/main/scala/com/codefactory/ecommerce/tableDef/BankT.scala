package com.codefactory.ecommerce.tableDef
import com.codefactory.ecommerce.tableModel.Bank
import slick.jdbc.MySQLProfile.api._
import com.codefactory.ecommerce.tableVariables.TableVariables

class BankT(tag: Tag) extends Table[Bank](tag, "BANK") with TableVariables {

  def id = column[Int](banksID, O.PrimaryKey)

  def balance = column[Int](bankBalance)

  def * = (id, balance) <> ((Bank.apply _).tupled, Bank.unapply)

  //  val banks = TableQuery[Bank]
}
