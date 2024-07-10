package io.github.ltassi.scalaqa

import org.gradle.api.Project
import java.io.File

internal fun resource(path: String, packageStructure: String = "io/github/ltassi/scalaqa/"): File = File(
    checkNotNull(Thread.currentThread().contextClassLoader.getResource(packageStructure + path)) {
        "Unable to access resource $path"
    }.toURI(),
)

internal fun Project.resolveOrFromResource(filename: String): File =
    resolveOr(filename) { resource(filename) }

internal fun Project.resolveOrElse(filename: String, orElse: File): File = resolveOr(filename) {
    orElse.also { require(it.exists()) { "File $it doesn't exist." } }
}

private fun Project.resolveOr(filename: String, orElseStrategy: () -> File) =
    rootDir.resolve(filename).takeIf { it.exists() } ?: orElseStrategy()
