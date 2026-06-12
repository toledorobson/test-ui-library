plugins {
    id("com.migrosone.sanalmarket.android.ui.sdk.android.library.compose")
    id("com.migrosone.sanalmarket.android.ui.sdk.android.library.publish")
}

android {
    namespace = "com.migrosone.sanalmarket.android.ui.sdk.theme"
}

dependencies {
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.tooling.preview)

    implementation(libs.androidx.compose.material3)

    debugImplementation(libs.androidx.compose.ui.tooling)

    testImplementation(libs.junit)
}
