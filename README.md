# Gradle Scala Extras

![CI/CD](https://github.com/tassiluca/gradle-scala-extras/actions/workflows/dispatcher.yaml/badge.svg)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This Gradle plugin aims to enhance the Scala Gradle core plugin with quality assurance tools and custom configurations.

## Features

- Support for [Scalafix](https://scalacenter.github.io/scalafix/) and [Scalafmt](https://scalameta.org/scalafmt/) with a default configuration that can be overridden following the [How to use](#how-to-use) section.
- Aggressive Scala compiler option to treat warnings as errors is applied by default (still configurable).
- Out-of-the-box configuration to generate aggregated subprojects scaladoc.

Other features may come in the future.

## How to use

```kotlin
plugins {
    id("io.github.tassiluca.gradle-scala-extras") version "<SELECT THE VERSION>"
}
```

The plugin is configurable through the `scalaExtras` extension:

```kotlin
scalaExtras {
    qa { 
        allWarningsAsErrors = false
        scalafix {
            configFile = "stringified path to the scalafix configuration"
        }
        scalafmt {
            configFile = "stringified path to the scalafmt configuration"
        } 
    }
}
```

- `allWarningsAsErrors` is a boolean property that allows to disable the aggressive compiler option to treat warnings as errors;
- `configFile` is a string that allows to set the path to the Scalafix / Scalafmt configuration file;
  - if not set, the plugin will search for a `.scalafix.conf` / `.scalafmt.conf` file in the project root directory. If not found, the default configuration is applied;
  - Default configurations can be found [here](./src/main/resources/io/github/tassiluca/scalaextras/).

Moreover, the plugin adds the following tasks to the project:
- `format` to automatically format the Scala source code adhering to the QA supported tools;
- `aggregateScaladoc` to generate the aggregated scaladoc for all the subprojects, including the root one. Generated documentation is placed in the root project `build/docs/aggregated-scaladoc` directory.
