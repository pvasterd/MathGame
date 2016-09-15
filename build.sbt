name := "MathGame"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "com.typesafe.akka" %% "akka-http-core" % "2.4.7"
libraryDependencies += "com.typesafe.akka" %% "akka-http-experimental" % "2.4.8"
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.8"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

