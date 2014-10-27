
import sbt._
import java.io._

scalaVersion := "2.11.1"

resolvers += Resolver.sonatypeRepo("snapshots")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Akka Repo" at "http://repo.akka.io/repository"

libraryDependencies += "org.ensime" %% "ensime" % "0.9.10-SNAPSHOT"

// guaranteed to exist when started from emacs
val JavaTools = new File(sys.env("JAVA_HOME"), "/lib/tools.jar")

unmanagedClasspath in Runtime += { Attributed.blank(JavaTools) }

mainClass in Compile := Some("org.ensime.server.Server")

fork := true

javaOptions ++= Seq (
  "-Dscala.usejavacp=true",
  "-Densime.config=/Users/aneverov/Dropbox/Development/Code/scala/scala-ensime-test/.ensime",
  "-Densime.cachedir=/Users/aneverov/Dropbox/Development/Code/scala/scala-ensime-test/.ensime_cache/",
  "-Densime.active=IGNORED"
)

javaOptions += "-Xms2048m"

javaOptions += "-Xmx2048m"

javaOptions += "-XX:ReservedCodeCacheSize=256m"

javaOptions += "-XX:MaxPermSize=512m"
