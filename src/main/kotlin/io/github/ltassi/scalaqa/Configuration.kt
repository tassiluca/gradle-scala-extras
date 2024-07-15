package io.github.ltassi.scalaqa

import io.github.ltassi.scalaqa.ScalaCompilerOptions.SCALA3_REPORT_UNUSED
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider
import java.io.File

/** A base configuration. */
open class Configuration(project: Project, defaultConfigurationFileName: String) {

    /** The resolved default configuration file. */
    protected val resolvedDefaultConfigurationFile = resource(defaultConfigurationFileName)

    /** The stringified path to the configuration file. */
    val configFile: Property<String> = project.objects.property(String::class.java)
        .convention(defaultConfigurationFileName)

    /** The resolved configuration file. */
    internal val resolvedConfigurationFile: Provider<File> = configFile
        .map { project.resolveOrElse(it, resolvedDefaultConfigurationFile) }
}

/** The configuration for scalafmt linter. */
class ScalafmtConfiguration(project: Project) : Configuration(project, DEFAULT_SCALAFMT_CONFIG_FILE) {

    /** Computes the version of scalafmt from [configFile]. */
    internal fun version() = resolvedConfigurationFile.get()
        .readText()
        .let { """version\s*=\s*([\d.]+)""".toRegex().find(it)?.groupValues?.get(1) }
        ?: error("Missing required 'version' parameter in scalafmt configuration")

    companion object {
        /** The default scalafmt configuration file name. */
        private const val DEFAULT_SCALAFMT_CONFIG_FILE = ".scalafmt.conf"
    }
}

/** The configuration for scalafix linter. */
class ScalafixConfiguration(project: Project) : Configuration(project, DEFAULT_SCALAFIX_CONFIG_FILE) {

    /** The compilation options to add to the Scala compiler for the default configuration. */
    internal val defaultCompilationOptions: Set<String> by lazy {
        resolvedConfigurationFile
            .takeIf { it.get().absolutePath == resolvedDefaultConfigurationFile.absolutePath }
            ?.let { setOf(SCALA3_REPORT_UNUSED) }
            .orEmpty()
    }

    companion object {
        /** The default scalafix configuration file name. */
        private const val DEFAULT_SCALAFIX_CONFIG_FILE = ".scalafix.conf"
    }
}
