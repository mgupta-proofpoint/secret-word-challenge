name := "secret-word"

scalaVersion := "2.13.3"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.10.1" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")

mainClass in (Compile, run) := Some("com.proofpoint.secretword.runner.SecretWordRunner")
