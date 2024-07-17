package io.github.tassiluca.scalaextras

import cz.augi.gradle.scalafmt.ScalafmtPlugin
import io.github.cosmicsilence.scalafix.ScalafixExtension
import io.github.cosmicsilence.scalafix.ScalafixPlugin
import io.github.tassiluca.scalaextras.ScalaCompilerOptions.FAIL_ON_WARNINGS
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.scala.ScalaCompile
import cz.augi.gradle.scalafmt.PluginExtension as ScalafmtExtension

/** The scala extras plugin entry point. */
class ScalaExtrasPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project.plugins) {
            apply(ScalafmtPlugin::class.java)
            apply(ScalafixPlugin::class.java)
        }
        val extension = project.extensions.create("scalaExtras", ScalaExtrasExtension::class.java, project)
        project.configureScalaFmt(extension.qa.scalafmtConfiguration)
        project.configureScalafix(extension.qa.scalafixConfiguration)
        project.configureFormatTask()
        project.configureCompilerOptions(extension)
    }

    private fun Project.configureScalaFmt(configuration: ScalafmtConfiguration) {
        afterEvaluate {
            logger.info("Picking up scalafmt configuration from ${configuration.resolvedConfigurationFile.get()}")
            logger.info("Using scalafmt version ${configuration.version()}")
            configureExtension<ScalafmtExtension> {
                configFilePath = configuration.resolvedConfigurationFile.get().absolutePath
            }
        }
        tasks.findByName(CHECK_TASK)?.dependsOn(CHECK_SCALAFMT_TASK)
    }

    private fun Project.configureScalafix(configuration: ScalafixConfiguration) {
        afterEvaluate {
            logger.info("Picking up scalafix configuration from ${configuration.resolvedConfigurationFile.get()}")
            configureExtension<ScalafixExtension> {
                setConfigFile(configuration.resolvedConfigurationFile.get().absolutePath)
            }
        }
    }

    private fun Project.configureFormatTask() = tasks.apply {
        register("format") {
            it.group = "Verification"
            it.description = "Format the Scala codebase using linting tools."
            it.dependsOn(SCALAFIX_TASK, SCALAFMT_TASK)
        }
        getByName(SCALAFMT_TASK).mustRunAfter(SCALAFIX_TASK)
    }

    private fun Project.configureCompilerOptions(extension: ScalaExtrasExtension) = afterEvaluate {
        val options = extension.options
            .plus(extension.qa.scalafixConfiguration.defaultCompilationOptions)
            .run { if (extension.qa.allWarningsAsErrors.get()) plus(FAIL_ON_WARNINGS) else this }
        logger.info("Additional compiler options: $options")
        tasks.withType(ScalaCompile::class.java) { compileTask ->
            compileTask.scalaCompileOptions.additionalParameters = options.toList()
        }
    }

    companion object {
        private const val SCALAFIX_TASK = "scalafix"
        private const val SCALAFMT_TASK = "scalafmtAll"
        private const val CHECK_TASK = "check"
        private const val CHECK_SCALAFMT_TASK = "checkScalafmtAll"

        private inline fun <reified T : Any> Project.configureExtension(crossinline action: T.() -> Unit) {
            extensions.configure(T::class.java) { it.action() }
        }
    }
}
