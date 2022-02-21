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
}

plugins {
    id(Plugins.ktlintGradle) version Versions.ktlintGradlePluginVersion
}

subprojects {
    apply(plugin = Plugins.ktlintGradle)

    ktlint {
        verbose.set(true)
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        }
        filter {
            exclude { element ->
                element.file
                    .toString()
                    .contains("generated/") ||
                    element.file
                        .toString()
                        .contains("AppDatabaseImpl.kt")
            }
        }
    }
}

ktlint {
    verbose.set(true)
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
    filter {
        exclude { element ->
            element.file
                .toString()
                .contains("generated/") ||
                element.file
                    .toString()
                    .contains("AppDatabaseImpl.kt")
        }
    }
}
