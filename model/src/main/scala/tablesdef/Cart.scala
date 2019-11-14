package tablesdef
import slick.jdbc.MySQLProfile.api._
class Cart(tag: Tag)
    extends Table[(Long, Long, Int, String, Int)](tag, "CART") {
  def id = column[Long]("CART_ID", O.PrimaryKey)

  def productId = column[Long]("CART_PRODUCT_ID")

  def quantity = column[Int]("CART_PRODUCT_QUANTITY")

  def status = column[String]("CART_PRODUCT_STATUS")

  def total = column[Int]("CART_TOTAL")

  def * = (id, productId, quantity, status, total)

//  val banks = TableQuery[Cart]

//  def product = foreignKey("PRODUCT_FK",productId, products)(_.id)
}
