import Dependencies._

ThisBuild / scalaVersion     := "2.13.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "nevec-db",
    libraryDependencies += munit % Test,
    libraryDependencies += "net.pishen" %% "annoy4s" % "0.10.0",
    libraryDependencies += "com.github.jelmerk" % "hnswlib-scala_2.13" % "1.0.1"
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
