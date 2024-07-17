package io.github.tassiluca.scalaextras

/** A subset of the Scala compiler options needed for the plugin implementation. */
object ScalaCompilerOptions {

    /** Scala 3 compiler option to report unused code elements. */
    internal const val SCALA3_REPORT_UNUSED = "-Wunused:all"

    /** Scala 2/3 compiler option to fail on warnings. */
    internal const val FAIL_ON_WARNINGS = "-Werror"
}
