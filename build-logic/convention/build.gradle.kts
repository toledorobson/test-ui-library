plugins {
    `kotlin-dsl`
}

group = "com.andrikod.testuilibrary.buildlogic"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "testuilibrary.android.application"
            implementationClass = "com.andrikod.testuilibrary.buildlogic.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "testuilibrary.android.library"
            implementationClass = "com.andrikod.testuilibrary.buildlogic.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "testuilibrary.android.library.compose"
            implementationClass = "com.andrikod.testuilibrary.buildlogic.AndroidLibraryComposeConventionPlugin"
        }
    }
}
