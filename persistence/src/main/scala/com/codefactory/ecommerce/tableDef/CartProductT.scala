package com.codefactory.ecommerce.tableDef
import com.codefactory.ecommerce.tableModel.CartProduct
import slick.jdbc.MySQLProfile.api._
import com.codefactory.ecommerce.tableVariables.TableVariables
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
class CartProductT(tag: Tag)
    extends Table[CartProduct](tag, "CART_PRODUCT")
    with TableVariables
    with QueryVariable {

  def c_id = column[Int](cartId)
  def p_id = column[Int](productId)

  def * =
    (c_id, p_id) <> ((CartProduct.apply _).tupled, CartProduct.unapply)

  def cartForeign =
    foreignKey(cartId, c_id, carts)(
     _.id,
     onDelete = ForeignKeyAction.Cascade,
     onUpdate = ForeignKeyAction.Cascade
    )

  def productForeign =
    foreignKey(productId, p_id, products)(
     _.id,
     onDelete = ForeignKeyAction.Cascade,
     onUpdate = ForeignKeyAction.Cascade
    )
}
