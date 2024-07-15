package io.github.ltassi.scalaqa

import cz.augi.gradle.scalafmt.ScalafmtPlugin
import io.github.cosmicsilence.scalafix.ScalafixExtension
import io.github.cosmicsilence.scalafix.ScalafixPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.scala.ScalaCompile
import cz.augi.gradle.scalafmt.PluginExtension as ScalafmtExtension

/** The scala QA plugin entry point. */
class ScalaQAPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project.plugins) {
            apply(ScalafmtPlugin::class.java)
            apply(ScalafixPlugin::class.java)
        }
        val extension = project.extensions.create("scalaExtras", ScalaExtrasExtension::class.java, project)
        project.configureScalaFmt(extension.qa.scalafmtConfiguration)
        project.configureScalafix(extension.qa.scalafixConfiguration)
        project.configureFormatTask()
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
        tasks.withType(ScalaCompile::class.java) {
            it.scalaCompileOptions.additionalParameters = configuration.defaultCompilationOptions.toList()
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
