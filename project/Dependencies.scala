import sbt._
import Keys._

object Dependencies {

  val slickVersion        = "3.3.2"
  val mySqlVersion        = "6.0.6"
  val akkaHttpVersion     = "10.1.10"
  val akkaStreamVersion   = "2.6.0"
  val akkaActorVersion    = "2.6.0"
  val logbackVersion      = "1.2.3"
  val scalaLoggingVersion = "3.9.2"

  val slick        = "com.typesafe.slick"         %% "slick"               % slickVersion
  val sql          = "mysql"                      % "mysql-connector-java" % mySqlVersion
  val akkaHttp     = "com.typesafe.akka"          %% "akka-http"           % akkaHttpVersion
  val akkaStream   = "com.typesafe.akka"          %% "akka-stream"         % akkaStreamVersion
  val akkaActor    = "com.typesafe.akka"          %% "akka-actor-typed"    % akkaActorVersion
  val logback      = "ch.qos.logback"             % "logback-classic"      % logbackVersion
  val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging"       % scalaLoggingVersion
}
