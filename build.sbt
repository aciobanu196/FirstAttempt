import Dependencies._
name := "EcommerceBegining"

scalaVersion := "2.13.0"

lazy val root = (project in file("."))
  .aggregate(api, model, persistence, services)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "EcommerceApplication"
  )

//A list of dependencies that will be used per module
lazy val apiDeps = Seq(
  akkaActor,
  akkaStream,
  akkaHttp,
  logback,
  scalaLogging
)

lazy val modelDeps = Seq(
  slick,
  logback,
  scalaLogging
)

lazy val persistenceDeps = Seq(
  slick,
  logback,
  scalaLogging
)

lazy val serviceDeps = Seq(
  logback,
  scalaLogging
)

//Assigning the relationship between modules and the dependencies that each module will use
lazy val api = (project in file("."))
  .dependsOn(persistence)
  .settings(
    libraryDependencies += apiDeps
  )
lazy val model = (project in file("."))
  .settings(
    libraryDependencies += modelDeps
  )
lazy val persistence = (project in file("."))
  .dependsOn(model)
  .settings(
    libraryDependencies += persistenceDeps
  )
lazy val services = (project in file("."))
  .dependsOn(persistence, api)
  .settings(
    libraryDependencies += serviceDeps
  )
