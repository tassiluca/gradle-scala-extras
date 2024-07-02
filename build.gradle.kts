import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    `java-gradle-plugin`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.qa)
}

group = "io.github.ltassi"

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation(libs.spotless)
    testImplementation(gradleTestKit())
    testImplementation(libs.bundles.kotlin.testing)
    testImplementation(libs.gradle.plugins.testkit)
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        showCauses = true
        showStackTraces = true
        showStandardStreams = true
        events(*TestLogEvent.values())
        exceptionFormat = TestExceptionFormat.FULL
    }
}
