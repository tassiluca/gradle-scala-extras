package io.github.ltassi.scalaqa

import org.gradle.api.Project
import java.io.File

internal fun resource(path: String, packageStructure: String = "io/github/ltassi/scalaqa/"): File = File(
    checkNotNull(Thread.currentThread().contextClassLoader.getResource(packageStructure + path)) {
        "Unable to access resource $path"
    }.path,
)

internal fun File.contains(filename: String): Boolean {
    require(exists() && isDirectory) { "File $this does not exist or is not a directory" }
    return listFiles()?.any { it.name == filename } ?: false
}

internal fun Project.resolveOrFromResource(filename: String): File =
    if (rootDir.contains(filename)) rootDir.resolve(filename) else resource(filename)
