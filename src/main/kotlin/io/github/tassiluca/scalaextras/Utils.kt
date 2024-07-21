package io.github.tassiluca.scalaextras

import org.gradle.api.Project
import java.io.File

internal fun resource(path: String, packageStructure: String = "io/github/tassiluca/scalaextras/"): String =
    checkNotNull(Thread.currentThread().contextClassLoader.getResource(packageStructure + path)) {
        "Unable to access resource $path"
    }.readText()

internal fun File.createWithContent(source: String): File = parentFile
    .apply { mkdirs() }
    .also { if (!exists() || readText() != source) writeText(source) }

internal fun Project.resolveOrFromResource(filename: String): String =
    resolveOr(filename) { resource(filename) }

internal fun Project.resolveOrElse(filename: String, orElse: String): String =
    resolveOr(filename) { orElse }

private fun Project.resolveOr(filename: String, orElseStrategy: () -> String) =
    rootDir.resolve(filename).takeIf { it.exists() }?.readText() ?: orElseStrategy()
