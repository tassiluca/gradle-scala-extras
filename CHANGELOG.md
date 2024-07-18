## 1.0.0 (2024-07-18)

### ⚠ BREAKING CHANGES

* introduce scalaExtras extension and move qa inside it

### Features

* add format task ([b88a92d](https://github.com/tassiluca/gradle-scala-extras/commit/b88a92d061b788dc2651c89966a6bbd3544ea6d2))
* add scalafix plugin ([513234f](https://github.com/tassiluca/gradle-scala-extras/commit/513234fcb34ec011ec93d8222c08df9e2543cf62))
* add support for additional compiler options ([0165fb6](https://github.com/tassiluca/gradle-scala-extras/commit/0165fb62ad36cf13dfdf05393954a35a2dddd820))
* apply spotless plugin ([6ce7a79](https://github.com/tassiluca/gradle-scala-extras/commit/6ce7a79e4ae2f08f75f3e3225865816caee9b08b))
* configure default scalafix extension ([0d5a8d2](https://github.com/tassiluca/gradle-scala-extras/commit/0d5a8d2b6041d50e34332f46de3a2dcba99ab427))
* configure scalafmt plugin ([f13654b](https://github.com/tassiluca/gradle-scala-extras/commit/f13654b899294e8678ac0c894d0fbb78b8250b42))
* introduce scalaExtras extension and move qa inside it ([e3f9963](https://github.com/tassiluca/gradle-scala-extras/commit/e3f996398c0d1c9eed7cf751aca8cd0d653b305c))

### Bug Fixes

* make defaultCompilationOptions lazy ([e85b5f3](https://github.com/tassiluca/gradle-scala-extras/commit/e85b5f3bb5c3ed0c5e08831d995c51436f65000e))
* put the config file in the root directory of the project ([880be4a](https://github.com/tassiluca/gradle-scala-extras/commit/880be4a6e7f24b2bd79d7906e0f5adfe532c265b))
* replace spotless with gradle scalafmt because of troubles with windows ([323b837](https://github.com/tassiluca/gradle-scala-extras/commit/323b837932f43b6f966b9a03bfb319b4b2f5470a))
* use absolutePath in place of path ([a163adc](https://github.com/tassiluca/gradle-scala-extras/commit/a163adc25d559f3e36e0973723621ed1400b6e4f))
* use correct configuration file ([af41672](https://github.com/tassiluca/gradle-scala-extras/commit/af41672cf6ca2946a658c4e9fc7ad40e6ece1211))

### Tests

* add single tasks to succeeded expected outcome ([da6246d](https://github.com/tassiluca/gradle-scala-extras/commit/da6246dda9019ccf28ddf1e4f308041c1ee6d063))
* add test for a custom configuration ([b2a2f45](https://github.com/tassiluca/gradle-scala-extras/commit/b2a2f453adc6a2d033ce864c962a044a5a839061))
* add test for a project with lint errors ([311769e](https://github.com/tassiluca/gradle-scala-extras/commit/311769e9cdc3c3f00fccf6bed0836defdb271e2d))
* move all tests to use Testkit api ([cb2836f](https://github.com/tassiluca/gradle-scala-extras/commit/cb2836f2549d25ab096cb6e9577532358427589d))
* move custom configuration to appropriate test folder ([486f13c](https://github.com/tassiluca/gradle-scala-extras/commit/486f13c1e9a970e3185763e4d3024fc0e710e8e6))
* test scalafix check task ([9c9dc70](https://github.com/tassiluca/gradle-scala-extras/commit/9c9dc70480c9018c9453fff464610cd7741bb5c2))

### Build and continuous integration

* add a minimal CI pipeline to build, test and check ([6168f43](https://github.com/tassiluca/gradle-scala-extras/commit/6168f43c064c9f4809d175ed4c0e7d7e4fab02e2))
* add deploy step ([87a95b1](https://github.com/tassiluca/gradle-scala-extras/commit/87a95b1190538156b17ba8c213db2e7aa0523391))
* add intermediate step to show current project directory ([b30b48d](https://github.com/tassiluca/gradle-scala-extras/commit/b30b48d9a05d4c94e59aa0100416ebc593820f6a))
* attempt to move files to /c ([8277668](https://github.com/tassiluca/gradle-scala-extras/commit/827766862c6933d37073420c7acfd0a77fe95d39))
* configure maven central publication ([5f844c7](https://github.com/tassiluca/gradle-scala-extras/commit/5f844c7a73d369d9e52fae5efe8d7c1fc270581d))
* configure semantic release bot ([2299aa8](https://github.com/tassiluca/gradle-scala-extras/commit/2299aa85e9fc844b56acd1ab2b0cea7b053f4314))
* configure token for downloading github packages ([2e9bdb2](https://github.com/tassiluca/gradle-scala-extras/commit/2e9bdb2b465d651251a712570bb4c3870d2938ff))
* dry deployment ([6c49c0e](https://github.com/tassiluca/gradle-scala-extras/commit/6c49c0e82302578ef63db2a96c3e290c07d9f04b))
* enable git hooks and automated scan ([789e682](https://github.com/tassiluca/gradle-scala-extras/commit/789e682802139a9f3b0cd902dc06a9c81455558f))
* fix project name ([1191008](https://github.com/tassiluca/gradle-scala-extras/commit/1191008bf350bdb863de9f8dbd1af599e7bc4b07))
* maven repository is useless since all gradle plugins are retrieved thanks to gradlePluginPortal repository ([7fe9a44](https://github.com/tassiluca/gradle-scala-extras/commit/7fe9a446966c386702e12dc0ee99001a69d4b777))
* on windows move also the hidden project files to C drive ([36c9e72](https://github.com/tassiluca/gradle-scala-extras/commit/36c9e722b6a5f49a1c23925600c60459e27fb2cf))
* use gradlePlugin with correct gradle plugin name ([aa6bed1](https://github.com/tassiluca/gradle-scala-extras/commit/aa6bed185b2ff95a03b75c63bea98e954efd4153))

### Refactoring

* add appropriately the scala compiler option if default config is used ([5a5f8af](https://github.com/tassiluca/gradle-scala-extras/commit/5a5f8af798e3ee6909ec38371b1cc2e83f7f97cd))
* add option report warnings as errors ([6ffd48c](https://github.com/tassiluca/gradle-scala-extras/commit/6ffd48ccae3f6795d5ed179c254669a83a6bcefa))
* reflect package strcture also in resource folders ([4ea196e](https://github.com/tassiluca/gradle-scala-extras/commit/4ea196e56b53e8b58fddc045b94abc46782078d9))
* rename ScalaFmtConfiguration to ScalafmtConfiguration ([b3eacd8](https://github.com/tassiluca/gradle-scala-extras/commit/b3eacd8e6639a5b3bb3e471fea366b7fbbc87383))
* rename ScalaQAPlugin to ScalaExtrasPlugin ([7812d02](https://github.com/tassiluca/gradle-scala-extras/commit/7812d0249c774b9e4ed01bb8db59cec8e982ee6e))
