name := "ehsop.basket"
version := "1.0"
scalaVersion := "2.12.1"
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
val circeVersion = "0.7.0"


lazy val root = (project in file(".")).
  settings(
    name := "basket",
    version := "1.0",
    scalaVersion := "2.12.1",
    mainClass in Compile := Some("BasketServer")
  )

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-core" % "10.0.5",
  "com.typesafe.akka" %% "akka-http" % "10.0.5",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.5",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.5",
  "com.typesafe.akka" %% "akka-http-jackson" % "10.0.5",
  "com.typesafe.akka" %% "akka-http-xml" % "10.0.5",
  "com.github.etaty" %% "rediscala" % "1.8.0",
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)