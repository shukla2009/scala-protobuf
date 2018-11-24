import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"
  lazy val scalaLogger = "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"
  lazy val logger = Seq(logback,scalaLogger)

}
