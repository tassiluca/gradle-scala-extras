import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    `java-gradle-plugin`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.publishOnCentral)
    alias(libs.plugins.gitSemanticVersioning)
    alias(libs.plugins.gradlePluginPublish)
}

group = "io.github.tassiluca"
inner class ProjectInfo {
    val repoOwner = "tassiluca"
    val longName = "Gradle Scala Extras Plugin"
    val description = "A plugin to enhance the Scala gradle core plugin with quality assurance tools"
    val website = "https://github.com/$repoOwner/$name"
    val vcsUrl = "$website.git"
    val scm = "scm:git:$website.git"
    val pluginImplementationClass = "$group.scalaextras.ScalaExtrasPlugin"
    val tags = listOf("scala", "qa", "quality assurance", "static analysis")
}
val projectInfo = ProjectInfo()

repositories {
    gradlePluginPortal()
    mavenCentral()
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

gitSemVer {
    /* The Gradle plugin portal does not support versions with a "+" symbol. */
    buildMetadataSeparator = "-"
}

/* Publication on Maven Central and the Plugin portal */

signing {
    if (System.getenv()["CI"].equals("true", ignoreCase = true)) {
        val signingKey: String? by project
        val signingPassword: String? by project
        useInMemoryPgpKeys(signingKey, signingPassword)
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
            tags = projectInfo.tags
        }
    }
}

publishOnCentral {
    projectLongName = projectInfo.longName
    projectDescription = projectInfo.description
    projectUrl = projectInfo.website
    scmConnection = projectInfo.scm
    licenseName = "Apache License, Version 2.0"
    licenseUrl = "https://www.apache.org/licenses/LICENSE-2.0"
    repoOwner = projectInfo.repoOwner
    repository("https://maven.pkg.github.com/${projectInfo.repoOwner}/$name", "GitHub") {
        user = repoOwner
        password = System.getenv("GITHUB_TOKEN")
    }
    publishing {
        publications {
            withType<MavenPublication> {
                pom {
                    developers {
                        developer {
                            name = "Luca Tassinari"
                            email = "luca.tassinari.2000@gmail.com"
                        }
                    }
                }
            }
        }
    }
}
