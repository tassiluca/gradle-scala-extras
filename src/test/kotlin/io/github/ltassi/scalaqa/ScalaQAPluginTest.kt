package io.github.ltassi.scalaqa

import io.github.mirkofelice.api.Testkit
import io.github.mirkofelice.api.Testkit.DEFAULT_TEST_FOLDER
import io.kotest.core.spec.style.FreeSpec
import java.io.File.separator

class ScalaQAPluginTest : FreeSpec({

    "It should be possible to apply the plugin to an empty project" {
        Testkit.projectTest("empty")
    }

    "Plugin applies correctly to a project" - {
        "with custom compiler options" {
            Testkit.projectTest("custom-options")
        }

        "with sources that are properly formatted" {
            Testkit.projectTest("working")
        }

        "with formatting and linting issues" {
            Testkit.projectTest("failing")
        }

        "with custom configuration exploiting conventions" {
            Testkit.projectTest("conventional-custom")
        }

        "with custom configuration" {
            Testkit.projectTest("custom")
        }
    }
}) {
    companion object {
        private const val PROJECT_NAME = "gradle-scala-qa"
        private val projectsBaseFolder =
            DEFAULT_TEST_FOLDER + "io${separator}github${separator}ltassi${separator}scalaqa$separator"

        private fun Testkit.projectTest(folder: String) =
            test(PROJECT_NAME, projectsBaseFolder + folder, forwardOutput = true)
    }
}
