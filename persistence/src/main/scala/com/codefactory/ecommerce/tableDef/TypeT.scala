package com.codefactory.ecommerce.tableDef
import slick.jdbc.MySQLProfile.api._
import com.codefactory.ecommerce.tableModel.Type
import com.codefactory.ecommerce.tableVariables.TableVariables

class TypeT(tag: Tag) extends Table[Type](tag, "TYPE") with TableVariables {

  def id = column[Int](typesID, O.PrimaryKey)

  def tname = column[String](typeName)

  def * = (id, tname) <> ((Type.apply _).tupled, Type.unapply)

}
