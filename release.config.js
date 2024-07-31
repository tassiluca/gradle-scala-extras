const publishCommands = `
./gradlew publishPlugins -Pgradle.publish.key=$GRADLE_PUBLISH_KEY -Pgradle.publish.secret=$GRADLE_PUBLISH_SECRET || exit 1
./gradlew uploadKotlinOSSRHToMavenCentralNexus uploadPluginMavenToMavenCentralNexus uploadPluginMarkerMavenToMavenCentralNexus releaseStagingRepositoryOnMavenCentral || exit 2
./gradlew publishKotlinOSSRHPublicationToGitHubRepository publishPluginMavenPublicationToGitHubRepository || true
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
