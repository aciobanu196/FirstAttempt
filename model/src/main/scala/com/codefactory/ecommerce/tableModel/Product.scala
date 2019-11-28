package com.codefactory.ecommerce.tableModel

final case class Product(
    id: Int,
    name: String,
    price: Float,
    productType: String,
    quantity: Int,
    isDeleted: Int
)

final case class ProductUpdate(
    name: Option[String] = None,
    price: Option[Float] = None,
    productType: Option[String] = None,
    quantity: Option[Int] = None,
    isDeleted: Option[Int] = None
) {
  def merge(prod: Product): Product =
    Product(
     prod.id,
     name.getOrElse(prod.name),
     price.getOrElse(prod.price),
     productType.getOrElse(prod.productType),
     quantity.getOrElse(prod.quantity),
     isDeleted.getOrElse(prod.isDeleted)
    )
}
