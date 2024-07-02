package io.github.ltassi.scalaqa

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.gradle.internal.impldep.org.junit.rules.TemporaryFolder
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome

class NoSourcesTests : FreeSpec({

    "It should be possible to run Gradle in Gradle" {
        val result = testSetup("tasks") { "" }
        println(result.output)
        result.tasks.map { it.outcome }.forEach { it shouldBe TaskOutcome.SUCCESS }
    }

    "It should be possible to apply the plugin to an empty project" {
        val result = testSetup("tasks") {
            """
            plugins {
                scala
                id("io.github.ltassi.gradle-scala-qa")
            }
            
            repositories {
                mavenCentral()
            }
            """.trimIndent()
        }
        println(result.output)
        result.tasks.map { it.outcome }.forEach { it shouldBe TaskOutcome.SUCCESS }
    }
}) {
    companion object {
        fun testSetup(taskName: String, buildFile: () -> String): BuildResult =
            setupProjectBuild(buildFile).let { testFolder ->
                GradleRunner.create()
                    .withProjectDir(testFolder.root)
                    .withPluginClasspath()
                    .withArguments(taskName)
                    .build() // this actually runs Gradle!
            }

        private fun setupProjectBuild(content: () -> String): TemporaryFolder = setupProjectBuild(content())

        private fun setupProjectBuild(content: String): TemporaryFolder = TemporaryFolder().apply {
            create()
            newFile("build.gradle.kts").writeText(content)
        }
    }
}
