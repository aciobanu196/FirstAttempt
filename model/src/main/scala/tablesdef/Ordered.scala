package tablesdef
import slick.jdbc.MySQLProfile.api._
class Ordered(tag: Tag) extends Table[(Long, Long, String)](tag, "ORDERED") {

  def id = column[Long]("ORDER_ID", O.PrimaryKey)

  def userID = column[Long]("ORDER_USER_ID")

  def status = column[String]("ORDER_STATUS")

  def * = (id, userID, status)

//  val orders = TableQuery[Ordered]
//
//  def user = foreignKey("USER_ORDER_FK",userID, users)(_.id)
}
