ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"



lazy val root = (project in file("."))
  .settings(
    name := "Oder"
  )

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.9.4",
  "org.scalatest" %% "scalatest" % "3.2.15"
)
