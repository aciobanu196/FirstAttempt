package com.codefactory.ecommerce.tableModel

final case class Cart(
    id: Int,
    productID: Int,
    quantity: Int,
    userID: Int,
    status: String = "pending",
    total: Float = 0
)
