package io.github.ltassi.scalaqa

import org.gradle.api.Project
import org.gradle.api.provider.Property

/**
 * The plugin extension.
 * @param project the project to apply the extension to.
 */
open class ScalaExtrasExtension(private val project: Project) {

    internal val qa = QAExtension()
    internal var options: Set<String> = emptySet()

    /** The set of additional compiler options. */
    fun additionalCompilerOptions(options: Set<String>) {
        this.options = options
    }

    /** DSL entry point for quality assurance configurations. */
    fun qa(apply: QAExtension.() -> Unit) = qa.apply()

    /** The quality assurance extension. */
    inner class QAExtension {
        internal val scalafmtConfiguration = ScalafmtConfiguration(project)
        internal val scalafixConfiguration = ScalafixConfiguration(project)

        /** Whether to treat all warnings as errors. */
        val allWarningsAsErrors: Property<Boolean> = project.objects.property(Boolean::class.java)
            .apply { convention(true) }

        /** DSL entry point for scalafmt configuration. */
        fun scalafmt(apply: ScalafmtConfiguration.() -> Unit) {
            scalafmtConfiguration.apply()
        }

        /** DSL entry point for scalafix configuration. */
        fun scalafix(apply: ScalafixConfiguration.() -> Unit) {
            scalafixConfiguration.apply()
        }
    }
}
