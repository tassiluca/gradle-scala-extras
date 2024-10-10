## [2.1.4](https://github.com/tassiluca/gradle-scala-extras/compare/2.1.3...2.1.4) (2024-10-10)

### Dependency updates

* **deps:** update dependency org.jetbrains.kotlin.jvm to v2.0.21 ([4702131](https://github.com/tassiluca/gradle-scala-extras/commit/47021314fff02b743ccf969761fbfc52da2849a6))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.108 ([9594d86](https://github.com/tassiluca/gradle-scala-extras/commit/9594d864a5708992094a5f1162450cfd64b007d2))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.109 ([a731d21](https://github.com/tassiluca/gradle-scala-extras/commit/a731d2144d73d656d23ecf3c3f2e933896f050f3))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.110 ([fd44960](https://github.com/tassiluca/gradle-scala-extras/commit/fd44960530efd24d1ff53b350b5b4ef69be74250))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.111 ([9912d20](https://github.com/tassiluca/gradle-scala-extras/commit/9912d20dd6da47111afa4b6b4f1a4b1750df4cb7))
* **deps:** update node.js to 20.18 ([712342a](https://github.com/tassiluca/gradle-scala-extras/commit/712342a4980b3215219086cfa965696b8256ea22))
* **deps:** update plugin kotlin-qa to v0.68.0 ([9d9343a](https://github.com/tassiluca/gradle-scala-extras/commit/9d9343a5c3dd6669c8909b946559bcb27757d6c3))
* **deps:** update plugin multijvmtesting to v1.2.8 ([5a82d49](https://github.com/tassiluca/gradle-scala-extras/commit/5a82d499f335bb66d17df3efd386cde458302853))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.13 ([7146eec](https://github.com/tassiluca/gradle-scala-extras/commit/7146eec115de2345c8a9ec230d899e4ea5642126))
* **deps:** update plugin publishoncentral to v5.1.8 ([30bd51b](https://github.com/tassiluca/gradle-scala-extras/commit/30bd51b8f1574db19df502511e7d0e574b8801a4))
* **deps:** update plugin publishoncentral to v5.1.9 ([b92d5ea](https://github.com/tassiluca/gradle-scala-extras/commit/b92d5ea0bda54bfefec02c0f4a6282fbc5cdec0d))

### Bug Fixes

* do not overwrite existing scala options, avoiding as well duplications ([bb00ac8](https://github.com/tassiluca/gradle-scala-extras/commit/bb00ac8e0d8093f63d04451a7be06d8f0d1c683b))

### Performance improvements

* avoid string templating when logging ([bc00628](https://github.com/tassiluca/gradle-scala-extras/commit/bc0062861ea2615e327a1bbcb5e7e429e98ae4d1))

### Build and continuous integration

* **deps:** update actions/checkout digest to eef6144 ([8f86194](https://github.com/tassiluca/gradle-scala-extras/commit/8f86194b878e57361528059371a4ae6e79616210))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.10 ([1c5c453](https://github.com/tassiluca/gradle-scala-extras/commit/1c5c453ef91b6f02a656d3c4f482624e95702789))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.7 ([6919be7](https://github.com/tassiluca/gradle-scala-extras/commit/6919be72421db24e965556975d0d244c58d42e00))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.8 ([9ddadfb](https://github.com/tassiluca/gradle-scala-extras/commit/9ddadfbf5e1b2109158630eed07895ca804ff55b))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.9 ([3e957f1](https://github.com/tassiluca/gradle-scala-extras/commit/3e957f17095e47b497b5ceb123ec819fca5457b2))
* **deps:** update dependency ubuntu to v24 ([3112cf6](https://github.com/tassiluca/gradle-scala-extras/commit/3112cf6dd7be6588b5355780dc91a44cd68a01e6))

### Refactoring

* make companion object private when public not needed ([01d3100](https://github.com/tassiluca/gradle-scala-extras/commit/01d3100f3436df9d41363e5fa916617868f20177))

## [2.1.3](https://github.com/tassiluca/gradle-scala-extras/compare/2.1.2...2.1.3) (2024-09-24)

### Dependency updates

* **core-deps:** update dependency gradle to v8.10.2 ([9dbd4fd](https://github.com/tassiluca/gradle-scala-extras/commit/9dbd4fd6f2b58556eb92b2079f477e050f52a423))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.103 ([7b86c62](https://github.com/tassiluca/gradle-scala-extras/commit/7b86c624471e32468863e87174ca2b25c4b59291))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.104 ([8c3f443](https://github.com/tassiluca/gradle-scala-extras/commit/8c3f443d189318a76dfdb4dd28130fbdcc827317))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.105 ([a79811a](https://github.com/tassiluca/gradle-scala-extras/commit/a79811a573e48da0c0a627636a1bdb94253e3fd1))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.106 ([86893ff](https://github.com/tassiluca/gradle-scala-extras/commit/86893ffa31067ee55b4a2894408d01a90bfcfc15))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.107 ([33b2a54](https://github.com/tassiluca/gradle-scala-extras/commit/33b2a549fe798c6425f91db4cb406022b44dfa0b))
* **deps:** update plugin com.gradle.develocity to v3.18.1 ([f40a5c6](https://github.com/tassiluca/gradle-scala-extras/commit/f40a5c6b9e65e96598e730b42a8fbd5130065fa8))
* **deps:** update plugin gradlepluginpublish to v1.3.0 ([25f9479](https://github.com/tassiluca/gradle-scala-extras/commit/25f9479881041e6adb6b88bea7579e6e58b4db43))
* **deps:** update plugin multijvmtesting to v1.2.6 ([46ae4fe](https://github.com/tassiluca/gradle-scala-extras/commit/46ae4fed161e840817ffc08c7ccb4bef82da53e2))
* **deps:** update plugin multijvmtesting to v1.2.7 ([f9b2259](https://github.com/tassiluca/gradle-scala-extras/commit/f9b22596e51f9df87a50cee673e9265192f21eac))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.10 ([e3d6334](https://github.com/tassiluca/gradle-scala-extras/commit/e3d633404ec336253ee09be904b258a2e8db7ae7))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.12 ([b38e896](https://github.com/tassiluca/gradle-scala-extras/commit/b38e8969e2fd750dd8fe5da31cdf5562d927175b))
* **deps:** update plugin publishoncentral to v5.1.7 ([930c231](https://github.com/tassiluca/gradle-scala-extras/commit/930c231e83211a38d8c1803b604abd052a053735))

### Build and continuous integration

* **deps:** update actions/setup-node action to v4.0.4 ([dc3371f](https://github.com/tassiluca/gradle-scala-extras/commit/dc3371f31e9e5cd52d12b82d315ee2e2d0fe4bb6))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.5 ([39e5de5](https://github.com/tassiluca/gradle-scala-extras/commit/39e5de5eea71c8d5766376dcd9135dd9830c0c4d))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.6 ([36ed993](https://github.com/tassiluca/gradle-scala-extras/commit/36ed993e31d21187891ee3b0d4cfe1f3201d98c6))

## [2.1.2](https://github.com/tassiluca/gradle-scala-extras/compare/2.1.1...2.1.2) (2024-09-09)

### Dependency updates

* **core-deps:** update dependency gradle to v8.10.1 ([bc5851c](https://github.com/tassiluca/gradle-scala-extras/commit/bc5851c1f96509a57c4a2ea152863df56d2d5763))
* **deps:** update dependency cz.augi:gradle-scalafmt to v1.21.3 ([f49a51a](https://github.com/tassiluca/gradle-scala-extras/commit/f49a51a803956dcf89637b2e786e0fec3f960a95))
* **deps:** update dependency org.jetbrains.kotlin.jvm to v2.0.20 ([5d4ad06](https://github.com/tassiluca/gradle-scala-extras/commit/5d4ad06f9d99d7f827b692ec93e255593eecc1f2))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.101 ([e18ff4d](https://github.com/tassiluca/gradle-scala-extras/commit/e18ff4d26c01a51be3a0ca7f46593241a2bf6c59))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.102 ([a346b42](https://github.com/tassiluca/gradle-scala-extras/commit/a346b427616b99b9b9a627b3f41a2a06c15eb100))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.96 ([600e36c](https://github.com/tassiluca/gradle-scala-extras/commit/600e36ce00e80d8b0c93843e91af8601f5d4eae0))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.97 ([6820d54](https://github.com/tassiluca/gradle-scala-extras/commit/6820d545834f1b59a52792ad0b0688d45b69e4e0))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.98 ([5b09de7](https://github.com/tassiluca/gradle-scala-extras/commit/5b09de7405818b3ee8251f6c1213bc12c7939332))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.99 ([c575018](https://github.com/tassiluca/gradle-scala-extras/commit/c5750188d4da6d064bfad7fbcb0c75358fb4bd3a))
* **deps:** update node.js to 20.17 ([2bb6bb9](https://github.com/tassiluca/gradle-scala-extras/commit/2bb6bb959a0f7f112616d2cfa3ccd1c0fb340720))
* **deps:** update plugin com.gradle.develocity to v3.18 ([43fac67](https://github.com/tassiluca/gradle-scala-extras/commit/43fac672b076e350c612349224692476f0f01d32))
* **deps:** update plugin gradlepluginpublish to v1.2.2 ([5e9e5f5](https://github.com/tassiluca/gradle-scala-extras/commit/5e9e5f51550b57c6102a4f0c22f8a9351afddb74))
* **deps:** update plugin kotlin-qa to v0.65.2 ([b3ab80b](https://github.com/tassiluca/gradle-scala-extras/commit/b3ab80bec3a883c9cb02088b466210fbb6bece07))
* **deps:** update plugin kotlin-qa to v0.66.0 ([e1f8d63](https://github.com/tassiluca/gradle-scala-extras/commit/e1f8d63003b6ae0c5f1d561bae552bff5995aeed))
* **deps:** update plugin kotlin-qa to v0.66.1 ([5047db5](https://github.com/tassiluca/gradle-scala-extras/commit/5047db54fb16ca0a6b44f7311d486a05bf8ccf3c))
* **deps:** update plugin multijvmtesting to v1.2.4 ([e61205b](https://github.com/tassiluca/gradle-scala-extras/commit/e61205b292033cfb1c170c73967d5aae11c00f1f))
* **deps:** update plugin multijvmtesting to v1.2.5 ([656e6c2](https://github.com/tassiluca/gradle-scala-extras/commit/656e6c2ab4a9c52054d0c6a5b50677dde719e067))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.9 ([84e3c0d](https://github.com/tassiluca/gradle-scala-extras/commit/84e3c0d20c4e725828be911cf774b9635e92f1aa))
* **deps:** update plugin publishoncentral to v5.1.6 ([9c7a06e](https://github.com/tassiluca/gradle-scala-extras/commit/9c7a06efb0fd034228cd8d4696b4b1eb6f3b82f2))

### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.4 ([0298e7a](https://github.com/tassiluca/gradle-scala-extras/commit/0298e7aa95b071ab2bb404a0189bfca735175783))

## [2.1.1](https://github.com/tassiluca/gradle-scala-extras/compare/2.1.0...2.1.1) (2024-08-14)

### Dependency updates

* **core-deps:** update dependency gradle to v8.10 ([19d49b0](https://github.com/tassiluca/gradle-scala-extras/commit/19d49b0104ecf08e153e8d4ab14c0644fe606be9))
* **deps:** update dependency org.jetbrains.kotlin.jvm to v2.0.10 ([0955e5d](https://github.com/tassiluca/gradle-scala-extras/commit/0955e5dbc2890b57d7a1c0dc85a8f764ddca8c74))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.93 ([6f8e6c1](https://github.com/tassiluca/gradle-scala-extras/commit/6f8e6c18b06310d4b4ca04f6f3f30d4f03500ef8))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.94 ([71bf047](https://github.com/tassiluca/gradle-scala-extras/commit/71bf0474a7bdd9d30ae73354f30ff8301c485582))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.95 ([76ccc69](https://github.com/tassiluca/gradle-scala-extras/commit/76ccc69d38108ed21c420cba463caef29d82ecfc))
* **deps:** update node.js to 20.16 ([47d08a3](https://github.com/tassiluca/gradle-scala-extras/commit/47d08a3b0dcdb4990f2a190b8bcedf4beb996148))
* **deps:** update plugin com.gradle.develocity to v3.17.6 ([ec21c64](https://github.com/tassiluca/gradle-scala-extras/commit/ec21c6470548e9a56355908d62102c75c285f9a7))
* **deps:** update plugin kotlin-qa to v0.62.4 ([b83ed29](https://github.com/tassiluca/gradle-scala-extras/commit/b83ed29b553ee4387c502d37938f230b9534bcac))
* **deps:** update plugin kotlin-qa to v0.65.0 ([8024dd2](https://github.com/tassiluca/gradle-scala-extras/commit/8024dd2542373e00d203c6ce78e2879baf06c922))
* **deps:** update plugin kotlin-qa to v0.65.1 ([0772b91](https://github.com/tassiluca/gradle-scala-extras/commit/0772b91733fba1cb317fbeb4195d2303b0175a86))
* **deps:** update plugin multijvmtesting to v1.2.2 ([3412c07](https://github.com/tassiluca/gradle-scala-extras/commit/3412c07c28f72736c3ddf209322fe4b94e3e5ce9))
* **deps:** update plugin multijvmtesting to v1.2.3 ([e025685](https://github.com/tassiluca/gradle-scala-extras/commit/e02568521a3466c157e0e5df4c905583b526b528))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v2.0.8 ([2cad4a9](https://github.com/tassiluca/gradle-scala-extras/commit/2cad4a933ea1211064061d4db9bcb19dc415372b))
* **deps:** update plugin publishoncentral to v5.1.4 ([2bd36dd](https://github.com/tassiluca/gradle-scala-extras/commit/2bd36dd67535257aac8cfa8b9fa58c0e6b2fcbe9))
* **deps:** update plugin publishoncentral to v5.1.5 ([3475fc8](https://github.com/tassiluca/gradle-scala-extras/commit/3475fc8555a37f354d26db55a5b09f88ab4adef4))

### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.1 ([5b71f48](https://github.com/tassiluca/gradle-scala-extras/commit/5b71f485b3c4ec13129344f2ce91b8acff878beb))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.2 ([ee61d53](https://github.com/tassiluca/gradle-scala-extras/commit/ee61d538d425acd3103f5aa1b64d8fcc06b17cdc))
* **deps:** update danysk/build-check-deploy-gradle-action action to v3.5.3 ([901cd70](https://github.com/tassiluca/gradle-scala-extras/commit/901cd7034190458618d01119f58ec54dfb535c6f))
* remove skipped check on 'success' job causing the skip of the job when the 'deploy' one is skipped ([4a3a30f](https://github.com/tassiluca/gradle-scala-extras/commit/4a3a30f3736f83249c83855aff8a41a3f4f19d89))
* run deploy step only when pushed to the main branch of the repository ([f27b01d](https://github.com/tassiluca/gradle-scala-extras/commit/f27b01d7cb64ca30a94abfcaa5603181de54ee40))

## [2.1.0](https://github.com/tassiluca/gradle-scala-extras/compare/2.0.1...2.1.0) (2024-07-31)

### Dependency updates

* **api-deps:** update dependency scalafmt to v3.8.3 ([3406b55](https://github.com/tassiluca/gradle-scala-extras/commit/3406b55fc85fb09ab524fa7b638c4da170779a44))
* **core-deps:** update dependency gradle to v8.9 ([e499334](https://github.com/tassiluca/gradle-scala-extras/commit/e49933472a0ef8edccc33956762193671dad542e))

### Build and continuous integration

* **deps:** pin dependencies ([9ec3e99](https://github.com/tassiluca/gradle-scala-extras/commit/9ec3e9961773bc9bdb9c871e5bdf70bbce7bcbd0))
* include skipped jobs in 'success' conditional rules ([2a183ad](https://github.com/tassiluca/gradle-scala-extras/commit/2a183adb8d40da0bf5d4207f5a88dfd78b3b6fa9))

### General maintenance

* add renovate configuration ([ffa38f0](https://github.com/tassiluca/gradle-scala-extras/commit/ffa38f0676424215eb6978963523e2e2230a42cf))
* **config:** migrate config renovate.json ([b6b7646](https://github.com/tassiluca/gradle-scala-extras/commit/b6b7646ed6e4f2e19fe4ed751647bb81f1cedbcf))
* remove unusued spotless entry ([1fd50c4](https://github.com/tassiluca/gradle-scala-extras/commit/1fd50c4c5df03c2ccfe07993063be38cd33ea090))
* **renovate:** remove 'prConcurrentLimit' and 'stabilityDays' ([c862f62](https://github.com/tassiluca/gradle-scala-extras/commit/c862f622e3c9dff77f48fa5e5e19142c4e8e2007))
* update renovate config to trigger minor update on QA dependencies ([5e4be94](https://github.com/tassiluca/gradle-scala-extras/commit/5e4be94655f4e1c8e5ac3c9e1747008eef70f510))
* use 'matchDepNames' for scalafmt dep ([18dd2a8](https://github.com/tassiluca/gradle-scala-extras/commit/18dd2a801527ed5fe79f0f7d37eb17c5ebbe3751))

## [2.0.1](https://github.com/tassiluca/gradle-scala-extras/compare/2.0.0...2.0.1) (2024-07-23)

### Bug Fixes

* configure multiJvm plugin to target all LTS from java 8 ([ac8e729](https://github.com/tassiluca/gradle-scala-extras/commit/ac8e7293b91b5755ecc11cc63dddcda9f52bfa3e))

### Build and continuous integration

* disable fail fast and add the Build-Test-Check-Dry-Deploy step as needed for the Success one ([c9490f3](https://github.com/tassiluca/gradle-scala-extras/commit/c9490f38b6c388409a2349d760ea608b2981de6b))

## [2.0.0](https://github.com/tassiluca/gradle-scala-extras/compare/1.0.1...2.0.0) (2024-07-22)

### ⚠ BREAKING CHANGES

* This change may cause build failures for projects depending on the previous default configurations.

### Features

* change default configuration for scalafmt and scalafix ([6665035](https://github.com/tassiluca/gradle-scala-extras/commit/66650358e7bc05bfff06c9140f6d74e99407ef14))

### Tests

* remove gradle output forward ([5fc705c](https://github.com/tassiluca/gradle-scala-extras/commit/5fc705c0dc55be609a484901d085cc6d8af83cce))

### Build and continuous integration

* add concurrency constraints ([e435696](https://github.com/tassiluca/gradle-scala-extras/commit/e4356963d8854e6ae4c5b0c7a17af96c260c4995))
* add success and dispatcher jobs ([3e7ebce](https://github.com/tassiluca/gradle-scala-extras/commit/3e7ebce76b40d007c3e9f1f0bcd6599799ada489))
* change release order, first maven central then gradle plugins portal ([7f71d58](https://github.com/tassiluca/gradle-scala-extras/commit/7f71d58c3c9a4893b501e36c36e1f221c9414adb))

## [1.0.1](https://github.com/tassiluca/gradle-scala-extras/compare/1.0.0...1.0.1) (2024-07-22)

### Bug Fixes

* resources must be read as text and loaded upfront in projects linked as jar ([8e46b38](https://github.com/tassiluca/gradle-scala-extras/commit/8e46b38d828fa57202d173e23918e5bcd753c983))

### General maintenance

* add README.md ([f696683](https://github.com/tassiluca/gradle-scala-extras/commit/f69668375bb8ea0d8cf2b4118536e5712cc47526))
* create LICENSE ([65ed27f](https://github.com/tassiluca/gradle-scala-extras/commit/65ed27f40bdaf5059d3c8606d717ffd697e70aae))

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
