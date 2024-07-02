package io.github.ltassi.scalaqa

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.diffplug.gradle.spotless.ScalaExtension
import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import io.github.cosmicsilence.scalafix.ScalafixPlugin
import io.github.ltassi.scalaqa.configutations.ScalaFmtConfiguration

/** The scala QA plugin entry point. */
class ScalaQAPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project.plugins) {
            apply(SpotlessPlugin::class.java)
            apply(ScalafixPlugin::class.java)
        }
        val extension = project.extensions.create("scalaQA", ScalaQAExtension::class.java, project)
        project.configureScalaFmt(extension.scalaFmtConfiguration)
    }

    private fun Project.configureScalaFmt(configuration: ScalaFmtConfiguration) {
        logger.info("Pickup scalafmt configuration from ${configuration.configFile.get()}")
        logger.info("Using scalafmt version ${configuration.version}")
        configureExtension<SpotlessExtension> {
            isEnforceCheck = true
            scala {
                it.scalafmt(configuration.version).configFile(configuration.configFile.get())
            }
        }
    }

    companion object {
        private inline fun <reified T : Any> Project.configureExtension(crossinline action: T.() -> Unit) {
            extensions.configure(T::class.java) { it.action() }
        }
    }
}
