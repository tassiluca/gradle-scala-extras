package io.github.ltassi.scalaqa

import io.github.ltassi.scalaqa.configutations.ScalaFmtConfiguration
import org.gradle.api.Project

/**
 * The scala QA plugin extension.
 * @param project the project to apply the extension to.
 */
open class ScalaQAExtension(project: Project) {

    internal val scalaFmtConfiguration = ScalaFmtConfiguration(project)

    /** DSL entry point for scalafmt configuration. */
    fun scalafmt(apply: ScalaFmtConfiguration.() -> Unit) {
        scalaFmtConfiguration.apply()
    }
}
