plugins {
    id("testuilibrary.android.application")
}

android {
    namespace = "com.andrikod.testuilibrary.sample"

    defaultConfig {
        applicationId = "com.andrikod.testuilibrary.sample"
    }
}

dependencies {
    implementation(project(":ui-compose"))
    implementation(project(":ui-view"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.kotlinx.coroutines.android)

    debugImplementation(libs.androidx.compose.ui.tooling)
}
