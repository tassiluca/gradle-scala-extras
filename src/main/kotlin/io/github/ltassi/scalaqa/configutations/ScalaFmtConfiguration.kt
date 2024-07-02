package io.github.ltassi.scalaqa.configutations

import org.gradle.api.Project
import org.gradle.api.provider.Property

/** The configuration for scalafmt linter. */
class ScalaFmtConfiguration(private val project: Project) {
    /** The stringified path to the scalafmt configuration file. */
    val configFile: Property<String> = project.objects.property(String::class.java)
        .apply { convention(DEFAULT_SCALAFMT_CONFIG_FILE) }

    /** The version of scalafmt to use. */
    val version: Property<String> = project.objects.property(String::class.java)
        .apply { convention(computeVersionFromConfigFile()) }

    private fun computeVersionFromConfigFile() =
        resource(configFile.get()).readText().substringAfter("version=").substringBefore("\n")

    companion object {
        private const val DEFAULT_SCALAFMT_CONFIG_FILE = "scalafmt.conf"

        private fun resource(path: String) =
            checkNotNull(Thread.currentThread().contextClassLoader.getResource(path)) {
                "Unable to access resource $path"
            }
    }
}
