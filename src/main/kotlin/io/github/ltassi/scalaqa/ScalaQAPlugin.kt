package io.github.ltassi.scalaqa

import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import io.github.cosmicsilence.scalafix.ScalafixExtension
import io.github.cosmicsilence.scalafix.ScalafixPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.scala.ScalaCompile

/** The scala QA plugin entry point. */
class ScalaQAPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project.plugins) {
            apply(SpotlessPlugin::class.java)
            apply(ScalafixPlugin::class.java)
        }
        val extension = project.extensions.create("scalaQA", ScalaQAExtension::class.java, project)
        project.configureScalaFmt(extension.scalaFmtConfiguration)
        project.configureScalafix(extension.scalafixConfiguration)
    }

    private fun Project.configureScalaFmt(configuration: ScalaFmtConfiguration) {
        logger.info("Picking up scalafmt configuration from ${configuration.configFile.get()}")
        logger.info("Using scalafmt version ${configuration.version}")
        configureExtension<SpotlessExtension> {
            isEnforceCheck = true
            scala {
                it.scalafmt(configuration.version).configFile(configuration.configFile.get())
            }
        }
    }

    private fun Project.configureScalafix(configuration: ScalafixConfiguration) {
        logger.info("Picking up scalafix configuration from ${configuration.configFile.get()}")
        configureExtension<ScalafixExtension> {
            setConfigFile(configuration.configFile.get())
        }
        tasks.withType(ScalaCompile::class.java) {
            it.scalaCompileOptions.additionalParameters = listOf("-Wunused:all")
        }
    }

    companion object {
        private inline fun <reified T : Any> Project.configureExtension(crossinline action: T.() -> Unit) {
            extensions.configure(T::class.java) { it.action() }
        }
    }
}
