name := """trent"""
organization := "com.clivern"

version := "1.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.11"

libraryDependencies += filters
libraryDependencies += evolutions
libraryDependencies += jdbc
libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"
libraryDependencies += "com.mashape.unirest" % "unirest-java" % "1.4.9"
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.2"
libraryDependencies += "org.apache.httpcomponents" % "httpasyncclient" % "4.1.1"
libraryDependencies += "org.apache.httpcomponents" % "httpmime" % "4.5.2"
libraryDependencies += "org.json" % "json" % "20160212"
libraryDependencies += "junit" % "junit" % "4.12"
libraryDependencies += "commons-io" % "commons-io" % "2.4"