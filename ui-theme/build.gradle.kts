plugins {
    id("com.migrosone.uilibrary.android.library.compose")
    id("com.migrosone.uilibrary.android.library.publish")
}

android {
    namespace = "com.migrosone.uilibrary.theme"
}

dependencies {
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.tooling.preview)

    implementation(libs.androidx.compose.material3)

    debugImplementation(libs.androidx.compose.ui.tooling)

    testImplementation(libs.junit)
}
