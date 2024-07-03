package io.github.ltassi.scalaqa

import io.github.mirkofelice.api.Testkit
import io.kotest.core.spec.style.FreeSpec

class ScalaQAPluginTest : FreeSpec({

    "It should be possible to apply the plugin to an empty project" {
        Testkit.projectTest("empty")
    }

    "Plugin applies correctly to a project" - {
        "with sources that are properly formatted" {
            Testkit.projectTest("working")
        }

        "with formatting and linting issues" {
            Testkit.projectTest("failing")
        }

        "with custom configuration" {
            Testkit.projectTest("custom")
        }
    }
}) {
    companion object {
        private const val PROJECT_NAME = "gradle-scala-qa"

        private fun Testkit.projectTest(folder: String) =
            test(PROJECT_NAME, DEFAULT_TEST_FOLDER + folder, forwardOutput = true)
    }
}
