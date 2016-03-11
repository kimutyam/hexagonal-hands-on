name := """hexagonal-hands-on"""

lazy val playJson4sVersion = "0.4.1"

lazy val commonSettings = Seq(
  scalaVersion := "2.11.7"
)

lazy val projects = Project(
  id = "hexagonal-example",
  base = file("hexagonalExample")
).enablePlugins(PlayScala)
  .settings(commonSettings)
  .settings(
    scalaSource in Compile := baseDirectory.value / "src" / "main" / "scala",
    scalaSource in Test := baseDirectory.value / "src" / "test" / "scala",
    resourceDirectory in Compile := baseDirectory.value / "src" / "main" / "resources",
    resourceDirectory in Test := baseDirectory.value / "src" / "test" / "resources"
  )
  .dependsOn(
    portWebService % "test->test;compile->compile",
    portBatch % "test->test;compile->compile",
    portPersistence % "test->test;compile->compile",
    portThirdPartyAPI % "test->test;compile->compile"
  ).aggregate(
  domain,
  application,
  port
)

lazy val domain = Project(
  id = "domain",
  base = file("hexagonalExample/domain")
).settings(commonSettings)
  .aggregate(
    domainCore,
    domainThirdParty
  )

lazy val domainCore = Project(
  id = "domain-core",
  base = file("hexagonalExample/domain/boundedContext/core")
).settings(commonSettings)

lazy val domainThirdParty = Project(
  id = "domain-thirdParty",
  base = file("hexagonalExample/domain/boundedContext/thirdParty")
).settings(commonSettings)

lazy val application = Project(
  id = "application",
  base = file("hexagonalExample/application")
).settings(commonSettings)
  .dependsOn(
    domainCore % "test->test;compile->compile",
    domainThirdParty % "test->test;compile->compile"
  )

lazy val port = Project(
  id = "port",
  base = file("hexagonalExample/port")
).settings(commonSettings)
  .aggregate(
    primaryPort,
    secondaryPort
  )

lazy val primaryPort = Project(
  id = "primary-port",
  base = file("hexagonalExample/port/primary")
).settings(commonSettings)
  .aggregate(
    portWebService,
    portBatch
  )

lazy val secondaryPort = Project(
  id = "secondary-port",
  base = file("hexagonalExample/port/secondary")
).settings(commonSettings)
  .aggregate(
    portPersistence,
    portThirdPartyAPI
  )

lazy val portWebService = Project(
  id = "primary-port-web-service",
  base = file("hexagonalExample/port/primary/webService")
).settings(commonSettings)
  .enablePlugins(PlayScala)
  .settings(
    scalaSource in Compile := baseDirectory.value / "src" / "main" / "scala",
    scalaSource in Test := baseDirectory.value / "src" / "test" / "scala",
    resourceDirectory in Compile := baseDirectory.value / "src" / "main" / "resources",
    resourceDirectory in Test := baseDirectory.value / "src" / "test" / "resources",
    libraryDependencies ++= Seq(
      "com.github.tototoshi" %% "play-json4s-jackson" % playJson4sVersion,
      "com.github.tototoshi" %% "play-json4s-test-jackson" % playJson4sVersion % "test"
    )
  )
  .dependsOn(
    application % "test->test;compile->compile"
  )

lazy val portBatch = Project(
  id = "primary-port-batch",
  base = file("hexagonalExample/port/primary/batch")
).settings(commonSettings)
  .dependsOn(
    application % "test->test;compile->compile"
  )

lazy val portPersistence = Project(
  id = "port-persistence",
  base = file("hexagonalExample/port/secondary/persistence")
).settings(commonSettings)
  .dependsOn(
    application % "test->test;compile->compile"
  )

lazy val portThirdPartyAPI = Project(
  id = "port-api",
  base = file("hexagonalExample/port/secondary/thirdPartyAPI")
).settings(commonSettings)
  .dependsOn(
    application % "test->test;compile->compile"
  )
