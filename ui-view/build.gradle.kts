plugins {
    id("testuilibrary.android.library")
}

android {
    namespace = "com.andrikod.testuilibrary.view"
    testNamespace = "com.andrikod.testuilibrary.view.test"
}

dependencies {
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.runner)
}
