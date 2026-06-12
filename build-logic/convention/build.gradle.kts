plugins {
    `kotlin-dsl`
}

group = "com.migrosone.sanalmarket.android.ui.sdk.buildlogic"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.vanniktech.mavenPublishPlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.migrosone.sanalmarket.android.ui.sdk.android.application"
            implementationClass = "com.migrosone.sanalmarket.android.ui.sdk.buildlogic.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.migrosone.sanalmarket.android.ui.sdk.android.library"
            implementationClass = "com.migrosone.sanalmarket.android.ui.sdk.buildlogic.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "com.migrosone.sanalmarket.android.ui.sdk.android.library.compose"
            implementationClass = "com.migrosone.sanalmarket.android.ui.sdk.buildlogic.AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibraryPublish") {
            id = "com.migrosone.sanalmarket.android.ui.sdk.android.library.publish"
            implementationClass = "com.migrosone.sanalmarket.android.ui.sdk.buildlogic.AndroidLibraryPublishingConventionPlugin"
        }
    }
}
