name := "SbtExampleProject"

version := "0.1"

scalaVersion := "2.13.6"

val scalaParserCombinators = "1.1.2"
val scalaTest = "3.0.8"
val jsoup = "1.12.1"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % scalaParserCombinators,
  "org.scalatest" %% "scalatest" % scalaTest,
  "org.jsoup" % "jsoup" % jsoup
)
