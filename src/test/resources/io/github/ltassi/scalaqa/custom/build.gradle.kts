plugins {
    scala
    id("io.github.ltassi.gradle-scala-qa")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang:scala3-library_3:3.5.1-RC1-bin-20240625-b3f113e-NIGHTLY")
}
