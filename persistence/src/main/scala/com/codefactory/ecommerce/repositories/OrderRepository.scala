package com.codefactory.ecommerce.repositories
import com.codefactory.ecommerce.tableQuerryVariable.QueryVariable
import com.typesafe.scalalogging.LazyLogging
import slick.jdbc.MySQLProfile.backend
import slick.jdbc.MySQLProfile.api._
import scala.concurrent.ExecutionContext

final case class OrderRepository() extends LazyLogging with QueryVariable {}
