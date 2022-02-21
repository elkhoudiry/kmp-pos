@file:Suppress("UNUSED_VARIABLE")

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform-resources")
    id(Plugins.sqlDelight)
}

group = "com.elkhoudiry"
version = "0.0.1"

repositories {
    mavenCentral()
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

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                api(JetbrainsDependencies.coroutinesCore)
                api(JetbrainsDependencies.kotlinXSerializationJson)
                api(KoinDependencies.koinCore)
                api(MultiplatformDependencies.mokoResources)
                api(MultiplatformDependencies.sqlDelightRuntimeDriver)
                api(MultiplatformDependencies.sqlDelightCoroutinesExtensions)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                api(JetbrainsDependencies.coroutinesAndroid)
                api(MultiplatformDependencies.mokoResourcesAndroid)
                api(MultiplatformDependencies.sqlDelightAndroidDriver)
                api(KoinDependencies.koinAndroid)
            }
        }
        val androidAndroidTestRelease by getting
        val androidTest by getting {
            dependsOn(androidAndroidTestRelease)
        }
        val desktopMain by getting {
            dependencies {
                api(MultiplatformDependencies.sqlDelightJVMDriver)
            }
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 31
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.elkhoudiry.domain"
    multiplatformResourcesSourceSet = "commonMain"
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.elkhoudiry.pos"
    }
}
