plugins {
    id("com.migrosone.sanalmarket.android.ui.sdk.android.application")
}

android {
    namespace = "com.migrosone.sanalmarket.android.ui.sdk.sample"

    defaultConfig {
        applicationId = "com.migrosone.sanalmarket.android.ui.sdk.sample"
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
