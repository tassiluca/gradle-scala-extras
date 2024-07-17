plugins {
    scala
    id("io.github.tassiluca.gradle-scala-extras")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang:scala3-library_3:3.5.1-RC1-bin-20240625-b3f113e-NIGHTLY")
    testImplementation("org.scalatest:scalatest_3:3.2.19")
    testRuntimeOnly("org.junit.platform:junit-platform-engine:1.10.2")
    testImplementation("org.junit.platform:junit-platform-launcher:1.10.2")
    testRuntimeOnly("org.scalatestplus:junit-5-10_3:3.2.19.0")
}

tasks.test {
    useJUnitPlatform {
        includeEngines("scalatest")
    }
}
