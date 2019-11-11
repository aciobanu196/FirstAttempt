name := "EcommerceBegining"

scalaVersion := "2.13.0"

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.2"

libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.1.10"

libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.0"

libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.0"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

//libraryDependencies += "io.spray" %% "spray-json" % "1.3.4"

//val circeVersion = "0.11.1"
//
//libraryDependencies ++= Seq(
//  "io.circe" %% "circe-core",
//  "io.circe" %% "circe-generic",
//  "io.circe" %% "circe-parser"
//).map(_ % circeVersion)
