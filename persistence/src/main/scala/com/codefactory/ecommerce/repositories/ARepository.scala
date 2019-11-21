package com.codefactory.ecommerce.repositories

import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext

final case class ARepository() extends LazyLogging with QueryVariable {

  def getProducts()(implicit ec: ExecutionContext, db: backend.Database) =
    db.run {
      products.result
    }

}

// WILL KEEP FOR NOW AS REFERENCE
