object Versions {
    // Kotlin
    const val kotlinVersion = "1.6.10"
    const val kotlinXJsonVersion = "1.3.2"
    const val coroutinesVersion = "1.6.0"

    // Gradle
    const val androidGradleBuildVersion = "7.0.4"
    const val ktlintGradlePluginVersion = "10.2.1"

    // AndroidX
    const val lifecycleVersion = "2.4.0"
    const val appcompatVersion = "1.4.1"
    const val androidXCoreKtxVersion = "1.7.0"

    // Koin
    const val koinVersion = "3.1.4"

    // Kotlin MultiPlatform Libs
    const val mokoResourcesVersion = "0.18.0"
    const val sqlDelightVersion = "1.5.3"

    // Test
    const val junit4Version = "4.13.2"
}

object ClassPaths {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlinVersion}"
    const val androidGradleBuildTools = "com.android.tools.build:gradle:${Versions.androidGradleBuildVersion}"
    const val mokoResourcesGenerator = "dev.icerock.moko:resources-generator:${Versions.mokoResourcesVersion}"
    const val sqlDelight = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelightVersion}"
}

object Plugins{
    const val kotlin = "kotlin"
    const val ktlintGradle = "org.jlleitschuh.gradle.ktlint"
    const val sqlDelight = "com.squareup.sqldelight"
}

object AndroidXDependencies {
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycleRunTimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.androidXCoreKtxVersion}"
}

object KoinDependencies {
    const val koinCore = "io.insert-koin:koin-core:${Versions.koinVersion}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinVersion}"
}

object JetbrainsDependencies{
    const val kotlinXSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinXJsonVersion}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
}

object MultiplatformDependencies{
    const val mokoResources = "dev.icerock.moko:resources:${Versions.mokoResourcesVersion}"
    const val mokoResourcesAndroid = "dev.icerock.moko:resources-compose:${Versions.mokoResourcesVersion}"
    const val sqlDelightRuntimeDriver = "com.squareup.sqldelight:runtime:${Versions.sqlDelightVersion}"
    const val sqlDelightJVMDriver = "com.squareup.sqldelight:sqlite-driver:${Versions.sqlDelightVersion}"
    const val sqlDelightAndroidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelightVersion}"
}

object TestDependencies{
    const val junit4 = "junit:junit:${Versions.junit4Version}"
}
