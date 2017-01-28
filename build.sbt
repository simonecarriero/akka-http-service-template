name := "akka-http-service-template"
organization := "org.example"
version := "1.0"
scalaVersion := "2.12.1"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += Resolver.sonatypeRepo("public")
resolvers += Resolver.sonatypeRepo("snapshots")
resolvers += DefaultMavenRepository

libraryDependencies ++= {
  val akkaHttpV = "10.0.2"
  val circeV = "0.7.0"
  Seq(
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "io.circe" %% "circe-core" % circeV,
    "io.circe" %% "circe-generic" % circeV,
    "io.circe" %% "circe-parser" % circeV,
    "de.heikoseeberger" %% "akka-http-circe" % "1.12.0"
  )
}
