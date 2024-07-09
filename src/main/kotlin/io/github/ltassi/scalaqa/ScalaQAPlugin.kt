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
        val extension = project.extensions.create("scalaQA", ScalaQAExtension::class.java, project)
        project.configureScalaFmt(extension.scalaFmtConfiguration)
        project.configureScalafix(extension.scalafixConfiguration)
    }

    private fun Project.configureScalaFmt(configuration: ScalafmtConfiguration) {
        logger.info("Picking up scalafmt configuration from ${configuration.configFile.get()}")
        logger.info("Using scalafmt version ${configuration.version}")
        configureExtension<ScalafmtExtension> {
            configFilePath = configuration.configFile.get()
        }
        project.tasks.findByName("check")?.dependsOn("checkScalafmtAll")
    }

    private fun Project.configureScalafix(configuration: ScalafixConfiguration) {
        logger.info("Picking up scalafix configuration from ${configuration.configFile.get()}")
        configureExtension<ScalafixExtension> {
            setConfigFile(configuration.configFile.get())
        }
        tasks.withType(ScalaCompile::class.java) {
            it.scalaCompileOptions.additionalParameters = configuration.defaultCompilationOptions.toList()
        }
    }

    companion object {
        private inline fun <reified T : Any> Project.configureExtension(crossinline action: T.() -> Unit) {
            extensions.configure(T::class.java) { it.action() }
        }
    }
}
