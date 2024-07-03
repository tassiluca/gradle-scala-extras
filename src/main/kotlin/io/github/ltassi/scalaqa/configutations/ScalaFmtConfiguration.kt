package io.github.ltassi.scalaqa.configutations

import io.github.ltassi.scalaqa.resolveOrFromResource
import org.gradle.api.Project
import org.gradle.api.provider.Property
import java.io.File

/** The configuration for scalafmt linter. */
class ScalaFmtConfiguration(project: Project) {
    /** The stringified path to the scalafmt configuration file. */
    val configFile: Property<String> = project.objects.property(String::class.java)
        .apply { convention(project.resolveOrFromResource(DEFAULT_SCALAFMT_CONFIG_FILE).path) }

    /** Computes the version of scalafmt from [configFile]. */
    internal val version = File(configFile.get())
        .readText()
        .let { """version\s*=\s*([\d.]+)""".toRegex().find(it)?.groupValues?.get(1) }
        ?: error("Missing required 'version' parameter in scalafmt configuration")

    companion object {
        /** The default scalafmt configuration file name. */
        const val DEFAULT_SCALAFMT_CONFIG_FILE = ".scalafmt.conf"
    }
}
