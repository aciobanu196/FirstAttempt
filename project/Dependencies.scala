import Dependencies.mysqlDriver
import sbt._
import Keys._

object Dependencies {

  private[this] val slickVersion        = "3.3.2"
  private[this] val mySqlVersion        = "6.0.6"
  private[this] val akkaHttpVersion     = "10.1.10"
  private[this] val akkaStreamVersion   = "2.6.0"
  private[this] val akkaActorVersion    = "2.6.0"
  private[this] val logbackVersion      = "1.2.3"
  private[this] val scalaLoggingVersion = "3.9.2"
  private[this] val flyWayVersion       = "2.4.0"
  private[this] val mysqlDriverVersion  = "8.0.18"

  val slick        = "com.typesafe.slick"         %% "slick"               % slickVersion
  val sql          = "mysql"                      % "mysql-connector-java" % mySqlVersion
  val akkaHttp     = "com.typesafe.akka"          %% "akka-http"           % akkaHttpVersion
  val akkaStream   = "com.typesafe.akka"          %% "akka-stream"         % akkaStreamVersion
  val akkaActor    = "com.typesafe.akka"          %% "akka-actor-typed"    % akkaActorVersion
  val logback      = "ch.qos.logback"             % "logback-classic"      % logbackVersion
  val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging"       % scalaLoggingVersion
  val flyWay       = "org.hsqldb"                 % "hsqldb"               % flyWayVersion
  val mysqlDriver  = "mysql"                      % "mysql-connector-java" % mysqlDriverVersion

  //A list of dependencies that will be used per module
  lazy val commonDeps = Seq(
    libraryDependencies ++= Seq(
      logback,
      scalaLogging,
      mysqlDriver
    ),
    scalaVersion := "2.13.0"
  )

  lazy val apiDeps =
    commonDeps ++ (libraryDependencies ++= Seq(
      akkaActor,
      akkaStream,
      akkaHttp
//      mysqlDriver
    ))

  lazy val modelDeps =
    commonDeps ++ (libraryDependencies ++= Seq(
      slick
    ))

  lazy val persistenceDeps =
    commonDeps ++ (libraryDependencies ++= Seq(
      slick
    ))

  lazy val serviceDeps =
    commonDeps ++ (libraryDependencies ++= Seq(
      ))
}

//val circeVersion = "0.11.1"
//
//libraryDependencies ++= Seq(
//  "io.circe" %% "circe-core",
//  "io.circe" %% "circe-generic",
//  "io.circe" %% "circe-parser"
//).map(_ % circeVersion)

//Will add it when I will need it
