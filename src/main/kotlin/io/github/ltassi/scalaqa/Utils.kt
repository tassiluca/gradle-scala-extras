package io.github.ltassi.scalaqa

import java.io.File

internal fun resource(path: String) = checkNotNull(Thread.currentThread().contextClassLoader.getResource(path)) {
    "Unable to access resource $path"
}

internal fun File.contains(filename: String): Boolean {
    require(exists() && isDirectory) { "File $this does not exist or is not a directory" }
    return listFiles()?.any { it.name == filename } ?: false
}
