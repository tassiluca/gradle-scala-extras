package io.github.tassiluca.scalaextras

import io.github.tassiluca.scalaextras.ScalaCompilerOptions.SCALA3_REPORT_UNUSED
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider
import java.io.File

/** A base configuration. */
open class Configuration(project: Project, defaultConfigurationFileName: String) {

    /** The default configuration. */
    protected val defaultConfiguration = resource(defaultConfigurationFileName)

    /** The stringified path to the configuration file. */
    val configFile: Property<String> = project.objects.property(String::class.java)
        .convention(defaultConfigurationFileName)

    /** The resolved configuration. */
    internal val resolvedConfiguration: Provider<String> = configFile
        .map { project.resolveOrElse(it, defaultConfiguration) }

    /** The file into which the [resolvedConfiguration] is reified. */
    internal val generatedConfigurationFile: File = project.layout.buildDirectory
        .dir(GENERATED_CONFIGURATIONS_FOLDER)
        .get()
        .asFile
        .also { it.mkdirs() }
        .resolve(defaultConfigurationFileName)

    private companion object {
        /** The folder where generated configurations are stored. */
        private const val GENERATED_CONFIGURATIONS_FOLDER = "scala-extras"
    }
}

/** The configuration for scalafmt linter. */
class ScalafmtConfiguration(project: Project) : Configuration(project, DEFAULT_SCALAFMT_CONFIG_FILE) {

    /** Computes the version of scalafmt from [configFile]. */
    internal fun version() = resolvedConfiguration.get()
        .let { """version\s*=\s*([\d.]+)""".toRegex().find(it)?.groupValues?.get(1) }
        ?: error("Missing required 'version' parameter in scalafmt configuration")

    private companion object {
        /** The default scalafmt configuration file name. */
        private const val DEFAULT_SCALAFMT_CONFIG_FILE = ".scalafmt.conf"
    }
}

/** The configuration for scalafix linter. */
class ScalafixConfiguration(project: Project) : Configuration(project, DEFAULT_SCALAFIX_CONFIG_FILE) {

    /** The compilation options to add to the Scala compiler for the default configuration. */
    internal fun defaultCompilationOptions(): Set<String> = resolvedConfiguration
        .takeIf { it.get() == defaultConfiguration }
        ?.let { setOf(SCALA3_REPORT_UNUSED) }
        .orEmpty()

    private companion object {
        /** The default scalafix configuration file name. */
        private const val DEFAULT_SCALAFIX_CONFIG_FILE = ".scalafix.conf"
    }
}
