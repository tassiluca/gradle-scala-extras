package io.github.ltassi.scalaqa.configutations

import io.github.ltassi.scalaqa.contains
import io.github.ltassi.scalaqa.resource
import org.gradle.api.Project
import org.gradle.api.provider.Property
import java.io.File

/** The configuration for scalafmt linter. */
class ScalaFmtConfiguration(project: Project) {
    /** The stringified path to the scalafmt configuration file. */
    val configFile: Property<String> = project.objects.property(String::class.java)
        .apply {
            convention(
                if (project.rootDir.contains(DEFAULT_SCALAFMT_CONFIG_FILE)) {
                    DEFAULT_SCALAFMT_CONFIG_FILE
                } else {
                    resource(DEFAULT_SCALAFMT_CONFIG_FILE).path
                }
            )
        }

    /** Computes the version of scalafmt from [configFile]. */
    internal val version = File(configFile.get())
        .readText()
        .let { """version\s*=\s*([\d.]+)""".toRegex().find(it)?.groupValues?.get(1) }
        ?: error("Missing required 'version' parameter in scalafmt configuration")

    companion object {
        const val DEFAULT_SCALAFMT_CONFIG_FILE = ".scalafmt.conf"
    }
}
