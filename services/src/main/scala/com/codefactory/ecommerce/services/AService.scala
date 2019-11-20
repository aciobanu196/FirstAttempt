package com.codefactory.ecommerce.services

import com.codefactory.ecommerce.repositories.ARepository
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend

import scala.concurrent.ExecutionContext

final case class AService(private val aRepo: ARepository) extends LazyLogging {

  def getProducts()(implicit ec: ExecutionContext, db: backend.Database) = aRepo.getProducts

}
