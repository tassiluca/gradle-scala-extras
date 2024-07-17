import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    `java-gradle-plugin`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.qa)
}

group = "io.github.tassiluca"
inner class ProjectInfo {
    val longName = "Gradle Scala Extras Plugin"
    val description = "A plugin to enhance the Scala gradle core plugin with quality assurance tools"
    val website = "https://github.com/tassiluca/$name"
    val vcsUrl = "$website.git"
    val scm = "scm:git:$website.git"
    val pluginImplementationClass = "$group.scalaextras.ScalaExtrasPlugin"
    val tags = listOf("scala", "qa", "quality assurance", "static analysis")
}
val projectInfo = ProjectInfo()

repositories {
    mavenCentral()
    maven {
        setOf(libs.gradle.scalafix)
            .map { it.get() }
            .map { "${it.group?.split(".")?.lastOrNull() ?: error("No group found for $it")}/${it.name}" }
            .forEach { url = uri("https://maven.pkg.github.com/$it") }
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GH_USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation(libs.gradle.scalafmt)
    implementation(libs.gradle.scalafix)
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

gradlePlugin {
    plugins {
        website = projectInfo.website
        vcsUrl = projectInfo.vcsUrl
        create("") {
            id = "${project.group}.${project.name}"
            displayName = projectInfo.longName
            description = projectInfo.description
            implementationClass = projectInfo.pluginImplementationClass
            tags.set(projectInfo.tags)
        }
    }
}
