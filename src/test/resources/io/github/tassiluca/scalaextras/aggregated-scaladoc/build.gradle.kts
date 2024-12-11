plugins {
    scala
    `java-library`
    id("io.github.tassiluca.gradle-scala-extras")
}

allprojects {
    apply(plugin = "scala")
    apply(plugin = "java-library")
    apply(plugin = "io.github.tassiluca.gradle-scala-extras")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.scala-lang:scala3-library_3:3.6.1")
    }
}
