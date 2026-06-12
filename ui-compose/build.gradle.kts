plugins {
    id("com.migrosone.sanalmarket.android.ui.sdk.android.library.compose")
    id("com.migrosone.sanalmarket.android.ui.sdk.android.library.publish")
}

android {
    namespace = "com.migrosone.sanalmarket.android.ui.sdk.compose"
    resourcePrefix = "sanalmarket_android_ui_sdk_compose_"
}

dependencies {
    api(project(":ui-theme"))
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.icons.core.android)

    implementation(libs.androidx.compose.ui.tooling.preview)

    debugImplementation(libs.androidx.compose.ui.tooling)

    testImplementation(libs.junit)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.runner)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
