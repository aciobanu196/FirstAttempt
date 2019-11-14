package tablesdef
import slick.jdbc.MySQLProfile.api._
class Type(tag: Tag) extends Table[(Long, String)](tag, "PRODUCTS") {

  def id = column[Long]("TYPE_ID", O.PrimaryKey)

  def tname = column[String]("TYPE_NAME")

  def * = (id, tname)

//  val types = TableQuery[Type]
}
