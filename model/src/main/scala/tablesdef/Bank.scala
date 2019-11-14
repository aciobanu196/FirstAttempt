package tablesdef
import slick.jdbc.MySQLProfile.api._

class Bank(tag: Tag) extends Table[(Long, Long)](tag, "BANK") {

  def id = column[Long]("ACCOUNT_ID", O.PrimaryKey)

  def balance = column[Long]("BANK_BALANCE")

  def * = (id, balance)

//  val banks = TableQuery[Bank]
}
