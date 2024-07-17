plugins {
    id("com.gradle.develocity") version "3.17.5"
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.7"
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
