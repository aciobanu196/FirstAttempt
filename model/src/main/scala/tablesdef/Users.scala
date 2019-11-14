package tablesdef
import slick.jdbc.MySQLProfile.api._
import tablesdef.Bank

class Users(tag: Tag)
    extends Table[(Long, String, String, Long)](tag, "USERS") {
  def id = column[Long]("USER_ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("USER_NAME")

  def email = column[String]("USER_EMAIL")

  def bankId = column[Long]("USER_BANK_ID")

  def * = (id, name, email, bankId)

  //  def bank = foreignKey("BANK_FK", bankId, banks)(_.id)
  //
  //  val users = TableQuery[Users]

}
