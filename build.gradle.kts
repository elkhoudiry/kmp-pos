buildscript {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ClassPaths.kotlinGradlePlugin)
        classpath(ClassPaths.androidGradleBuildTools)
        classpath(ClassPaths.kotlinSerialization)
        classpath(ClassPaths.mokoResourcesGenerator)
        classpath(ClassPaths.sqlDelight)
    }
}

group = "com.elkhoudiry"
version = "0.0.1"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    apply(plugin = Plugins.ktlintGradle)
}

plugins {
    id(Plugins.ktlintGradle) version Versions.ktlintGradlePluginVersion
}

ktlint {
    filter {
        exclude("**/generated/**")
    }
}
