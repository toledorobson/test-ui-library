package com.andrikod.testuilibrary.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

internal const val COMPILE_SDK = 36
internal const val COMPILE_SDK_MINOR = 1
internal const val MIN_SDK = 23
internal const val TARGET_SDK = 36
internal const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

internal fun Project.configureAndroid(commonExtension: CommonExtension) {
    commonExtension.apply {
        compileSdk = COMPILE_SDK
        compileSdkMinor = COMPILE_SDK_MINOR

        defaultConfig.minSdk = MIN_SDK
        defaultConfig.testInstrumentationRunner = TEST_RUNNER

        compileOptions.sourceCompatibility = JavaVersion.VERSION_17
        compileOptions.targetCompatibility = JavaVersion.VERSION_17

        testOptions.unitTests.isIncludeAndroidResources = true
    }
}
