plugins {
    id("org.jetbrains.compose") version "1.0.1-rc2"
    id("com.android.application")
    kotlin("android")
}

group = "com.elkhoudiry"
version = "0.0.1"

dependencies {
    implementation(project(":shared-domain"))
    implementation(project(":shared-ui"))
    implementation(project(":shared-presentation"))
    implementation("androidx.activity:activity-compose:1.4.0")
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "com.elkhoudiry.android"
        minSdkVersion(24)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}