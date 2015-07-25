val scalaz = "org.scalaz" %% "scalaz-core" % "7.1.3"
val scalatest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
val argonaut = "io.argonaut" %% "argonaut" % "6.1"  
val http4sDsl  = "org.http4s" %% "http4s-dsl" % "0.8.4"
val http4sBlazeClient  = "org.http4s" %% "http4s-blazeclient" % "0.8.4"
val http4sArgonaut = "org.http4s" %% "http4s-argonaut" % "0.8.4"
val apacheCommons = "commons-codec" % "commons-codec" % "1.10"

lazy val commonSettings =  Seq(
  version := "0.0.1",
  scalaVersion := "2.11.7"
)
lazy val root = (project in file(".")).
  settings( commonSettings: _* ).
  settings(
    name := "scala-oauth2",
    libraryDependencies ++= Seq(
      scalatest,
      scalaz,
      http4sDsl,
      http4sBlazeClient,
      http4sArgonaut,
      argonaut,
      apacheCommons
    )
  )

scalacOptions in (Compile,doc) := Seq("-groups", "-implicits")
