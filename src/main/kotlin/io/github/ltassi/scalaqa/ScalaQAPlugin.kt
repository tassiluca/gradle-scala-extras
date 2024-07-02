package io.github.ltassi.scalaqa

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.diffplug.gradle.spotless.SpotlessPlugin
import com.diffplug.gradle.spotless.ScalaExtension
import com.diffplug.gradle.spotless.SpotlessExtension

/** The scala QA plugin entry point. */
class ScalaQAPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project.plugins) {
            apply(SpotlessPlugin::class.java)
        }
        val extension = project.extensions.create("scalaQA", ScalaQAExtension::class.java, this)
        val checkTask = project.tasks.findByName("check")
        project.configureExtension<SpotlessExtension> {
            isEnforceCheck = true
        }
        project.configureExtension<ScalaExtension> {
            scalafmt("3.8.2").configFile("scalafmt.conf")
        }
        checkTask?.dependsOn("spotlessCheck")
    }

    companion object {
        private inline fun <reified T : Any> Project.configureExtension(crossinline action: T.() -> Unit) {
            extensions.configure(T::class.java) { it.action() }
        }
    }
}
