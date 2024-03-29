import Dependencies._

name := "EcommerceBegining"

lazy val root = (project in file("."))
  .aggregate(api, model, persistence, services)
  .settings(commonDeps: _*)
  .enablePlugins(FlywayPlugin)
  .settings(
    Seq(
      flywayUrl := "jdbc:mysql://172.17.0.2:3306/ecommerce",
      flywayUser := "firstAttemptDBUser",
      flywayPassword := "Test1234!"
    )
  )

//Assigning the relationship between modules and the dependencies that each module will use
lazy val api = (project in file("api"))
  .dependsOn(services)
  .settings(apiDeps: _*)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](name,
                                       version,
                                       scalaVersion,
                                       sbtVersion,
                                       "commit" -> { git.gitHeadCommit.value }),
    buildInfoPackage := "EcommerceApplication"
  )

lazy val services = (project in file("services"))
  .dependsOn(persistence)
  .settings(serviceDeps: _*)

lazy val persistence = (project in file("persistence"))
  .dependsOn(model)
  .settings(persistenceDeps: _*)

lazy val model = (project in file("model"))
  .settings(modelDeps: _*)
