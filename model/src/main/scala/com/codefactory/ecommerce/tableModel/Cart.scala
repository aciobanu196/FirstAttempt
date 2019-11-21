package com.codefactory.ecommerce.tableModel

final case class Cart(id: Int,
                      quantity: Int,
                      status: String,
                      userID: Int,
                      total: Float,
                      cartProductID: String)
