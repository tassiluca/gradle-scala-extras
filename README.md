# Gradle Scala Extras

This Gradle plugin aims to enhance the Scala Gradle core plugin with quality assurance tools and custom configurations.

## Features

- Support for [Scalafix](https://scalacenter.github.io/scalafix/) and [Scalafmt](https://scalameta.org/scalafmt/) with a default configuration that can be overridden following the [How to use](#how-to-use) section.
  - Wartremover support is expected soon.
- Configuration of Scala compiler options;
- Aggressive Scala compiler option to treat warnings as errors is applied by default (still configurable).

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
    additionalCompilerOptions(setOf("-explain"))
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

- `additionalCompilerOptions` allows to add more options to the Scala compiler (this is necessary because the core Scala plugin allow only to replace the default options and not setting them incrementally);
- `allWarningsAsErrors` is a boolean property that allows to disable the aggressive compiler option to treat warnings as errors;
- `configFile` is a string that allows to set the path to the Scalafix / Scalafmt configuration file;
  - if not set, the plugin will search for a `.scalafix.conf` / `.scalafmt.conf` file in the project root directory. If not found, the default configuration is applied;
  - Default configurations can be found [here](./src/main/resources/io/github/tassiluca/scalaextras/).
