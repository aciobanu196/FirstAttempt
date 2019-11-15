package com.codefactory.ecommerce.tableVariables
trait TableVariables {

  final val usersID             = "USER_ID"
  final val userName            = "USER_NAME"
  final val userEmail           = "USER_EMAIL"
  final val userBankID          = "USER_BANK_ID"
  final val typesID             = "TYPE_ID"
  final val typeName            = "TYPE_NAME"
  final val productsID          = "PRODUCT_ID"
  final val productName         = "PRODUCT_NAME"
  final val productPrice        = "PRODUCT_PRICE"
  final val productTypeID       = "PRODUCT_TYPE_ID"
  final val productQuantity     = "PRODUCT_QUANTITY"
  final val orderID             = "ORDER_ID"
  final val orderUserID         = "ORDER_USER_ID"
  final val orderStatus         = "ORDER_STATUS"
  final val cartID              = "CART_ID"
  final val cartProductID       = "CART_PRODUCT_ID"
  final val cartProductQuantity = "CART_PRODUCT_QUANTITY"
  final val cartProductStatus   = "CART_PRODUCT_STATUS"
  final val cartTotal           = "CART_TOTAL"
  final val banksID             = "BANK_ID"
  final val bankBalance         = "BANK_BALANCE"

//  def id = column[Int]("BANK_ID", O.PrimaryKey)
//
//  def balance = column[Int]("BANK_BALANCE")

}
