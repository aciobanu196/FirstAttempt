package tablesdef
import slick.jdbc.MySQLProfile.api._
class Products(tag: Tag)
    extends Table[(Long, String, Int, Long, Int)](tag, "PRODUCTS") {
  def id = column[Long]("PRODUCT_ID", O.PrimaryKey)

  def name = column[String]("PRODUCT_NAME")

  def price = column[Int]("PRODUCT_PRICE")

  def typeId = column[Long]("PRODUCTS_TYPED_ID")

  def quantity = column[Int]("PRODUCT_QUANTITY")

  def * = (id, name, price, typeId, quantity)

//  def typeP = foreignKey("TYPE_FK", typeId, types)(_.id)
//
//  val products = TableQuery[Products]

}
