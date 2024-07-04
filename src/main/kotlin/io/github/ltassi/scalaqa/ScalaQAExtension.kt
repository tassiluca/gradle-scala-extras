package io.github.ltassi.scalaqa

import org.gradle.api.Project
import org.gradle.api.provider.Property

/**
 * The scala QA plugin extension.
 * @param project the project to apply the extension to.
 */
open class ScalaQAExtension(project: Project) {

    internal val scalaFmtConfiguration = ScalafmtConfiguration(project)
    internal val scalafixConfiguration = ScalafixConfiguration(project)

    /** Whether to treat all warnings as errors. */
    val allWarningsAsErrors: Property<Boolean> = project.objects.property(Boolean::class.java)
        .apply { convention(true) }

    /** DSL entry point for scalafmt configuration. */
    fun scalafmt(apply: ScalafmtConfiguration.() -> Unit) {
        scalaFmtConfiguration.apply()
    }

    /** DSL entry point for scalafix configuration. */
    fun scalafix(apply: ScalafixConfiguration.() -> Unit) {
        scalafixConfiguration.apply()
    }
}
