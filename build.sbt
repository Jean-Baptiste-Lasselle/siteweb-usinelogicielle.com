// import com.typesafe.sbt.SbtScalariform._

import scalariform.formatter.preferences._


name := "software-factory"

version := "1.0.0"

scalaVersion := "2.12.4"

resolvers += Resolver.jcenterRepo
resolvers += Resolver.sbtPluginRepo("releases")

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  "com.mohiva" %% "play-silhouette" % "5.0.0",
  "com.mohiva" %% "play-silhouette-password-bcrypt" % "5.0.0",
  "com.mohiva" %% "play-silhouette-persistence" % "5.0.0",
  "com.mohiva" %% "play-silhouette-crypto-jca" % "5.0.0",
  "org.webjars" %% "webjars-play" % "2.6.1",
  "org.webjars" % "bootstrap" % "3.3.7-1" exclude("org.webjars", "jquery"),
  "org.webjars" % "jquery" % "3.2.1",
  "net.codingwell" %% "scala-guice" % "4.1.0",
  "com.iheart" %% "ficus" % "1.4.1",
  "com.typesafe.play" %% "play-mailer" % "6.0.1",
  "com.typesafe.play" %% "play-mailer-guice" % "6.0.1",
  "com.enragedginger" %% "akka-quartz-scheduler" % "1.6.1-akka-2.5.x",
  "com.adrianhurt" %% "play-bootstrap" % "1.2-P26-B3",
  "com.mohiva" %% "play-silhouette-testkit" % "5.0.0" % "test",
  "com.typesafe.play" %% "play-slick" % "3.0.3",
  "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  "com.typesafe.slick" %% "slick" % "3.2.0",
  specs2 % Test,
  ehcache,
  guice,
  filters
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)

routesGenerator := InjectedRoutesGenerator

routesImport += "utils.route.Binders._"

// https://github.com/playframework/twirl/issues/105
TwirlKeys.templateImports := Seq()

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xfatal-warnings", // Fail the compilation if there are any warnings.
  //"-Xlint", // Enable recommended additional warnings.
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver.
  "-Ywarn-dead-code", // Warn when dead code is identified.
  "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
  "-Ywarn-nullary-override", // Warn when non-nullary overrides nullary, e.g. def foo() over def foo.
  "-Ywarn-numeric-widen", // Warn when numerics are widened.
  // Play has a lot of issues with unused imports and unsued params
  // https://github.com/playframework/playframework/issues/6690
  // https://github.com/playframework/twirl/issues/105
  "-Xlint:-unused,_"
)

//********************************************************
// Scalariform settings
//********************************************************

// defaultScalariformSettings
// scalariformSettings(true)
// scalariformAutoformat((0 == 0))
// scalariformAutoformat(_*)
// scalariformSettings(_*)
// scalariformSettings(false)
// scalariformAutoformat(true)
// scalariFormSettings
// settings(com.typesafe.packager.PackagerPlugin.packagerSettings:_*)
seq(scalariformSettings: _*)
seq(com.typesafe.packager.PackagerPlugin.packagerSettings:_*)

// -->> ajout JIBL d�but
// scalariformPreferences := scalariformPreferences.value
//    .setPreference(AlignSingleLineCaseStatements, true)
//    .setPreference(DoubleIndentConstructorArguments, true)
//    .setPreference(DanglingCloseParenthesis, Preserve)
resolvers ++= Seq(
  DefaultMavenRepository,
  "sonatype.release" at "http://oss.sonatype.org/content/repositories/releases",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

ScalariformKeys.preferences := FormattingPreferences().
  setPreference(FormatXml, false)
// -->> ajout JIBL fin

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(FormatXml, false)
  .setPreference(DoubleIndentConstructorArguments, false)
  .setPreference(DanglingCloseParenthesis, Preserve)


includeFilter in (Assets, LessKeys.less) := "*.less"

excludeFilter in (Assets, LessKeys.less) := "_*.less"


herokuAppName in Compile := "software-factory"
enablePlugins(JavaAppPackaging)