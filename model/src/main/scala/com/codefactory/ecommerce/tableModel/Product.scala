package com.codefactory.ecommerce.tableModel

final case class Product(
    id: Int,
    name: String,
    price: Float, //Changed to float for more precision
    productType: String,
    quantity: Int,
    isDeleted: Boolean
)
