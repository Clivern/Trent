name := """trent"""
organization := "com.clivern"

version := "1.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.11"

libraryDependencies += filters
libraryDependencies += evolutions
libraryDependencies += jdbc
libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"
