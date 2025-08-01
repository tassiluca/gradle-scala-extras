import Utils.inCI
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    `java-gradle-plugin`
    alias(libs.plugins.gitSemanticVersioning)
    alias(libs.plugins.gradlePluginPublish)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.publishOnCentral)
    alias(libs.plugins.multiJvmTesting)
}

group = "io.github.tassiluca"
description = "A plugin to enhance the Scala gradle core plugin with quality assurance and common useful tools"
class ProjectInfo {
    val repoOwner = "tassiluca"
    val longName = "Gradle Scala Extras Plugin"
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

multiJvm {
    /* Compile with Java 11. In CI test with all LTS versions from 11 onwards, otherwise with the latest java. */
    jvmVersionForCompilation.set(11)
    maximumSupportedJvmVersion.set(latestJavaSupportedByGradle)
    if (!inCI) {
        testByDefaultWith(latestJavaSupportedByGradle)
    }
}

dependencies {
    api(gradleApi())
    api(gradleKotlinDsl())
    api(libs.gradle.scalafmt)
    api(libs.gradle.scalafix)
    testImplementation(gradleTestKit())
    testImplementation(libs.bundles.kotlin.testing)
    testImplementation(libs.gradle.plugins.testkit)
}

tasks.withType<KotlinCompilationTask<*>>().configureEach {
    compilerOptions {
        allWarningsAsErrors = true
        freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
    }
}

tasks.withType<Test>().configureEach {
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

publishOnCentral {
    projectLongName.set(projectInfo.longName)
    projectDescription.set(description)
    projectUrl.set(projectInfo.website)
    scmConnection.set(projectInfo.scm)
    licenseName.set("Apache License, Version 2.0")
    licenseUrl.set("https://www.apache.org/licenses/LICENSE-2.0")
    repoOwner.set(projectInfo.repoOwner)
    repository("https://maven.pkg.github.com/${projectInfo.repoOwner}/${rootProject.name}", "github") {
        user.set(repoOwner)
        password.set(System.getenv("GITHUB_TOKEN"))
    }
}

publishing {
    publications {
        withType<MavenPublication> {
            pom {
                developers {
                    developer {
                        name.set("Luca Tassinari")
                        email.set("luca.tassinari.2000@gmail.com")
                    }
                }
            }
        }
    }
}

gradlePlugin {
    plugins {
        website.set(projectInfo.website)
        vcsUrl.set(projectInfo.vcsUrl)
        create("") {
            id = "$group.${project.name}"
            displayName = projectInfo.longName
            description = project.description
            implementationClass = projectInfo.pluginImplementationClass
            tags.set(projectInfo.tags)
        }
    }
}
