package io.github.ltassi.scalaqa

import org.gradle.api.Project
import org.gradle.api.provider.Property
import java.io.File

/** A base configuration. */
abstract class Configuration(project: Project) {

    /** The default configuration file name. */
    abstract val defaultConfigurationFileName: String

    /** The stringified path to the configuration file. */
    val configFile: Property<String> = project.objects.property(String::class.java)
        .apply { convention(project.resolveOrFromResource(defaultConfigurationFileName).absolutePath) }
}

/** The configuration for scalafmt linter. */
class ScalafmtConfiguration(project: Project) : Configuration(project) {

    override val defaultConfigurationFileName: String
        get() = DEFAULT_SCALAFMT_CONFIG_FILE

    /** Computes the version of scalafmt from [configFile]. */
    internal val version = File(configFile.get())
        .readText()
        .let { """version\s*=\s*([\d.]+)""".toRegex().find(it)?.groupValues?.get(1) }
        ?: error("Missing required 'version' parameter in scalafmt configuration")

    companion object {
        /** The default scalafmt configuration file name. */
        private const val DEFAULT_SCALAFMT_CONFIG_FILE = ".scalafmt.conf"
    }
}

/** The configuration for scalafix linter. */
class ScalafixConfiguration(project: Project) : Configuration(project) {

    override val defaultConfigurationFileName: String
        get() = DEFAULT_SCALAFIX_CONFIG_FILE

    /** The compilation options to add to the Scala compiler for the default configuration. */
    internal val defaultCompilationOptions: Set<String> = configFile
        .takeIf { File(it.get()).absolutePath == resource(defaultConfigurationFileName).absolutePath }
        ?.let { setOf(REPORT_UNUSED_OPTION) }
        .orEmpty()

    companion object {
        /** The default scalafix configuration file name. */
        private const val DEFAULT_SCALAFIX_CONFIG_FILE = ".scalafix.conf"

        /** Scala 3 compilation parameter to report unused code elements. */
        private const val REPORT_UNUSED_OPTION = "-Wunused:all"
    }
}
