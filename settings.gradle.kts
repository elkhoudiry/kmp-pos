pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
rootProject.name = "POS"

include(":android")
include(":desktop")
include(":shared-ui")
include(":shared-domain")
include(":shared-data")
include(":shared-presentation")
include("shared-di")
include("shared-di")
