package tableQuerry

import com.codefactory.ecommerce.tableDef._

object TableQuerries extends App {

//  val db = Database.forConfig("mydb")

//  val id = Await.result(
//    db.run(
//      (users returning users
//        .map(_.id)) += (0, "Tester Testing", "testerconfig@mail.com", 3)
//    ),
//    Duration.Inf)

//  println(id)

//  val setup = DBIO.seq(
//    (users.schema ++ banks.schema ++ carts.schema ++ products.schema ++ types.schema ++ orders.schema).create,
//    users += (1, "Tester Testing", "testerconfig@mail.com", 1))

//  val usersResult: Future[Seq[Long]] = db.run(
//    users.map(_.id).result
//  )
//
//  print(usersResult);

//  val setupFuture = db.run(setup)

//  val insertUsers: DBIO[Option[Int]] = users ++= Seq(
//    (1, "Ciobanu Alin", "alin.m.ciobanu@gmail.com", 1),
//    (2, "Testing Querries", "testtytest@mail.com", 2)
//  )
//  val insertAndPrintAction: DBIO[Unit] = insertUsers.map { usersInsertResult =>
//    // Print the number of rows inserted
//    usersInsertResult foreach { numRows =>
//      println(s"Inserted $numRows rows into the USERS table")
//    }
//  }
//
//  val insertProducts: DBIO[Option[Int]] = products ++= Seq(
//    (1, "cana", 10, 1, 50),
//    (2, "pian", 500, 2, 3)
//  )
//  println("USERS:")
//  db.run(users.result)
//    .map(_.foreach {
//      case (id, name, email, bankId) =>
//        println("  " + id + "\t" + name + "\t" + email + "\t" + bankId)
//    })

}
