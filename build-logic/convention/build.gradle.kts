plugins {
    `kotlin-dsl`
}

group = "com.migrosone.uilibrary.buildlogic"

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
            id = "com.migrosone.uilibrary.android.application"
            implementationClass = "com.migrosone.uilibrary.buildlogic.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.migrosone.uilibrary.android.library"
            implementationClass = "com.migrosone.uilibrary.buildlogic.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "com.migrosone.uilibrary.android.library.compose"
            implementationClass = "com.migrosone.uilibrary.buildlogic.AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibraryPublish") {
            id = "com.migrosone.uilibrary.android.library.publish"
            implementationClass = "com.migrosone.uilibrary.buildlogic.AndroidLibraryPublishingConventionPlugin"
        }
    }
}
