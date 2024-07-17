plugins {
    scala
    id("io.github.tassiluca.gradle-scala-extras")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang:scala3-library_3:3.5.1-RC1-bin-20240625-b3f113e-NIGHTLY")
}
