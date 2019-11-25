package com.codefactory.ecommerce.httpModel

final case class ProductsAndQuantities(product: Int, quantity: Int)

/**
 * [
 *   {
 *     "product": 1,
 *     "quantity": 100
 *   },
 *   {
 *     "product": 2,
 *     "quantity" : 1000
 *   }
 * ]
 *
 * */