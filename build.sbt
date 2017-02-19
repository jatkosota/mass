name := "mass"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

scalacOptions in ThisBuild ++= Seq(
  "-feature",
  "-language:implicitConversions",
  "-deprecation"
)

import org.ensime.EnsimeCoursierKeys._
ensimeServerVersion in ThisBuild := "2.0.0-SNAPSHOT"

