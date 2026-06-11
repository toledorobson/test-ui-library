plugins {
    id("com.migrosone.uilibrary.android.application")
}

android {
    namespace = "com.migrosone.uilibrary.sample"

    defaultConfig {
        applicationId = "com.migrosone.uilibrary.sample"
    }
}

dependencies {
    implementation(project(":ui-compose"))
    implementation(project(":ui-theme"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material.icons.core)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.kotlinx.coroutines.android)

    debugImplementation(libs.androidx.compose.ui.tooling)
}
