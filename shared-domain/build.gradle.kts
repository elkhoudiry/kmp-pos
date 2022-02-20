plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform-resources")
}

group = "com.elkhoudiry"
version = "0.0.1"

repositories {
    mavenCentral()
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
            }
        }
        val androidAndroidTestRelease by getting
        val androidTest by getting {
            dependsOn(androidAndroidTestRelease)
        }
        val desktopMain by getting {
            dependencies {
            }
        }
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(31)
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
