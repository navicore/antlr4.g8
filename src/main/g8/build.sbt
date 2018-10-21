name := "$name;format="Camel"$"

version := "1.0"

scalaVersion := "$scalaVersion$"

val antlrVer = "4.7.1"
enablePlugins(Antlr4Plugin)
antlr4Version in Antlr4 := antlrVer
antlr4PackageName in Antlr4 := Some("$package$.antlr")
antlr4GenListener in Antlr4 := false
antlr4GenVisitor in Antlr4 := true

libraryDependencies ++=
  Seq(

    "org.antlr" % "antlr4-runtime" % antlrVer,
    "org.antlr" % "stringtemplate" % "4.0.2",

    "org.rogach" %% "scallop" % "3.1.3",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "com.typesafe" % "config" % "1.3.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",

    "org.scalatest" %% "scalatest" % "3.0.5" % "test"

  )

mainClass in assembly := Some("$package$.Main")
assemblyJarName in assembly := "$name;format="Camel"$.jar"

assemblyMergeStrategy in assembly := {
  case PathList("reference.conf") => MergeStrategy.concat
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

