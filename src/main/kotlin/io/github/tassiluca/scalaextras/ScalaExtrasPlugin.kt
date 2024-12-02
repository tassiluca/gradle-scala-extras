package io.github.tassiluca.scalaextras

import cz.augi.gradle.scalafmt.ScalafmtPlugin
import io.github.cosmicsilence.scalafix.ScalafixExtension
import io.github.cosmicsilence.scalafix.ScalafixPlugin
import io.github.cosmicsilence.scalafix.ScalafixTask
import io.github.tassiluca.scalaextras.ScalaCompilerOptions.FAIL_ON_WARNINGS
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskProvider
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
        configureExtension<ScalafmtExtension> {
            configFilePath = configuration.generatedConfigurationFile.absolutePath
        }
        val populateTask = populateConfigurationTask(configuration)
        tasks.filter { it.name.contains("scalafmt", ignoreCase = true) && it.name != populateTask.get().name }
            .forEach { it.dependsOn(populateTask) }
        tasks.findByName(CHECK_TASK)?.dependsOn(CHECK_SCALAFMT_TASK)
    }

    private fun Project.configureScalafix(configuration: ScalafixConfiguration) {
        configureExtension<ScalafixExtension> {
            setConfigFile(configuration.generatedConfigurationFile.absolutePath)
        }
        val populateTask = populateConfigurationTask(configuration)
        tasks.withType(ScalafixTask::class.java) { it.dependsOn(populateTask) }
    }

    private fun Project.populateConfigurationTask(configuration: Configuration): TaskProvider<Task> =
        tasks.register("populate${configuration.javaClass.simpleName}") {
            it.doLast {
                logger.info("Picking up configuration {}", configuration.resolvedConfiguration.get())
                configuration.generatedConfigurationFile.createWithContent(configuration.resolvedConfiguration.get())
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
        val options = extension.qa.scalafixConfiguration.defaultCompilationOptions()
            .run { if (extension.qa.allWarningsAsErrors.get()) plus(FAIL_ON_WARNINGS) else this }
        tasks.withType(ScalaCompile::class.java) { compileTask ->
            compileTask.scalaCompileOptions.additionalParameters.apply {
                options.filter { it !in this }.forEach { add(it) }
                logger.info("Additional compiler options: {}", this)
            }
        }
    }

    private companion object {
        private const val SCALAFIX_TASK = "scalafix"
        private const val SCALAFMT_TASK = "scalafmtAll"
        private const val CHECK_TASK = "check"
        private const val CHECK_SCALAFMT_TASK = "checkScalafmtAll"

        private inline fun <reified T : Any> Project.configureExtension(crossinline action: T.() -> Unit) {
            extensions.configure(T::class.java) { it.action() }
        }
    }
}
