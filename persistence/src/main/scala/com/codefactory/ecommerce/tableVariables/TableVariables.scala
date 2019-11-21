package com.codefactory.ecommerce.tableVariables
trait TableVariables {

  // USER TABLE VARIABLES
  final val usersID = "USER_ID"
  final val userName = "USER_NAME"
  final val userEmail = "USER_EMAIL"
  final val userBankBalance = "USER_BALANCE"
  //END

  // PRODUCTS TABLE VARIABLES
  final val productsID = "PRODUCT_ID"
  final val productName = "PRODUCT_NAME"
  final val productPrice = "PRODUCT_PRICE"
  final val productTypeName = "PRODUCT_TYPE"
  final val productQuantity = "PRODUCT_QUANTITY"
  final val productDeletion = "IS_DELETED"
  //END

  //ORDER TABLE VARIABLES
  final val orderID = "ORDER_ID"
  final val orderUserID = "ORDER_USER_ID"
  final val orderStatus = "ORDER_STATUS"
  final val orderCartId = "ORDER_CART_ID"
  //END

  //CART TABLE VARIABLES
  final val cartID = "CART_ID"
  final val cartProductQuantity = "CART_PRODUCT_QUANTITY"
  final val cartProductStatus = "CART_PRODUCT_STATUS"
  final val cartTotal = "CART_TOTAL"
  final val userIDcart = "CART_USER_ID"
  //END

  // CARTPRODUCT TABLE VARIABLES - RELATIONSHIP BETWEEN THE TWO
  final val cartProductID = "CART_PRODUCT_ID"
  final val cartId = "C_ID"
  final val productId = "P_ID"
}
