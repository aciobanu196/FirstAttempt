package com.codefactory.ecommerce.tableModel

final case class Cart(id: Int,
                      productID: Int,
                      quantity: Int,
                      status: String,
                      total: Int)