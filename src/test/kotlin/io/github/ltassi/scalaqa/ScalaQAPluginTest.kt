package io.github.ltassi.scalaqa

import io.github.mirkofelice.api.Testkit
import io.kotest.core.spec.style.StringSpec
import java.nio.file.FileSystems

class ScalaQAPluginTest : StringSpec({

    val projectName = "gradle-scala-qa"
    val sep = FileSystems.getDefault().separator
    val baseFolder = Testkit.DEFAULT_TEST_FOLDER + "io${sep}github${sep}ltassi${sep}scalaqa${sep}"

    fun Testkit.projectTest(folder: String) = this.test(projectName, baseFolder + folder)

    "Test with sources" {
        Testkit.projectTest("workingTest")
    }

})
