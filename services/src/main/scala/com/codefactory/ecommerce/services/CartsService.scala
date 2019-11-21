package com.codefactory.ecommerce.services

import com.codefactory.ecommerce.repositories.CartRepository

case class CartsService(private val cRepo: CartRepository) {}
