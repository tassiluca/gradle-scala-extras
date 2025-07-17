plugins {
    id("com.gradle.develocity") version "4.0.2"
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.28"
    /* Provides a repository for downloading JVMs, provisioning them automatically if missing. */
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "gradle-scala-extras"

develocity {
    buildScan {
        termsOfUseUrl = "https://gradle.com/terms-of-service"
        termsOfUseAgree = "yes"
        uploadInBackground = !System.getenv("CI").toBoolean()
        publishing.onlyIf { it.buildResult.failures.isNotEmpty() }
    }
}

gitHooks {
    preCommit {
        tasks("check")
    }
    commitMsg { conventionalCommits() }
    createHooks(overwriteExisting = true)
}
