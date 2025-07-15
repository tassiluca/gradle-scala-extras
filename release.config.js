const publishCommands = `
./gradlew publishAllPublicationsToProjectLocalRepository zipMavenCentralPortalPublication releaseMavenCentralPortalPublication || exit 1
./gradlew publishPlugins -Pgradle.publish.key=$GRADLE_PUBLISH_KEY -Pgradle.publish.secret=$GRADLE_PUBLISH_SECRET || exit 2
./gradlew publishOSSRHPublicationToGithubRepository publishPluginMavenPublicationToGithubRepository publishPluginMarkerMavenPublicationToGithubRepository || true
`
const releaseBranches = ["master"]
const config = require('semantic-release-preconfigured-conventional-commits')
config.branches = releaseBranches
config.plugins.push(
    // Custom release commands
    ["@semantic-release/exec", {
        "publishCmd": publishCommands,
    }],
    "@semantic-release/github",
    "@semantic-release/git",
)
module.exports = config
