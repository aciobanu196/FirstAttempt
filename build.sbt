name := "EcommerceBegining"

version := "0.1"

scalaVersion := "2.13.0"

libraryDependencies+= "com.typesafe.slick" %% "slick" % "3.3.2"

libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"

libraryDependencies+= "com.typesafe.akka" %% "akka-http"   % "10.1.10"

libraryDependencies+= "com.typesafe.akka" %% "akka-stream" % "2.6.0"

libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.0"

//val circeVersion = "0.11.1"
//
//libraryDependencies ++= Seq(
//  "io.circe" %% "circe-core",
//  "io.circe" %% "circe-generic",
//  "io.circe" %% "circe-parser"
//).map(_ % circeVersion)