# Sanalmarket Android UI SDK

An Android UI library starter inspired by Accompanist's library-first module layout and Now in Android's convention-plugin build structure.

## Modules

- `:ui-compose` exposes Jetpack Compose components such as `MigrosButton`.
- `:ui-theme` exposes the Migros Compose theme, brand color tokens, typography, dimensions, and font resources.
- `:sample` demonstrates the Compose components and theme.
- `build-logic/convention` contains shared Gradle convention plugins.

## Install

Published artifacts:

```kotlin
dependencies {
    implementation("com.migrosone.sanalmarket.android.ui.sdk:sanalmarket-android-ui-sdk-compose:<version>")
    implementation("com.migrosone.sanalmarket.android.ui.sdk:sanalmarket-android-ui-sdk-theme:<version>")
}
```

Version catalog usage:

```toml
[versions]
sanalmarketAndroidUiSdk = "0.1.4-SNAPSHOT"

[libraries]
sanalmarket-android-ui-sdk-compose = { module = "com.migrosone.sanalmarket.android.ui.sdk:sanalmarket-android-ui-sdk-compose", version.ref = "sanalmarketAndroidUiSdk" }
sanalmarket-android-ui-sdk-theme = { module = "com.migrosone.sanalmarket.android.ui.sdk:sanalmarket-android-ui-sdk-theme", version.ref = "sanalmarketAndroidUiSdk" }
```

```kotlin
dependencies {
    implementation(libs.sanalmarket.android.ui.sdk.compose)
    implementation(libs.sanalmarket.android.ui.sdk.theme)
}
```

Use `mavenCentral()` in the consuming project's repositories.

## Verify

```bash
ANDROID_HOME=/Users/akin/Library/Android/sdk ANDROID_SDK_ROOT=/Users/akin/Library/Android/sdk ./gradlew :sample:assembleDebug :ui-theme:testDebugUnitTest :ui-compose:testDebugUnitTest lintDebug
```

Compile instrumentation test sources:

```bash
ANDROID_HOME=/Users/akin/Library/Android/sdk ANDROID_SDK_ROOT=/Users/akin/Library/Android/sdk ./gradlew :ui-theme:compileDebugAndroidTestKotlin :ui-compose:compileDebugAndroidTestKotlin
```

## Publishing

The publishable modules are `:ui-compose` and `:ui-theme`. The sample app and build logic are not published.

Coordinates:

- `com.migrosone.sanalmarket.android.ui.sdk:sanalmarket-android-ui-sdk-compose`
- `com.migrosone.sanalmarket.android.ui.sdk:sanalmarket-android-ui-sdk-theme`

The default version is configured in `gradle.properties`:

```properties
VERSION_NAME=0.1.4-SNAPSHOT
```

Override it from CI or the command line:

```bash
ORG_GRADLE_PROJECT_VERSION_NAME=0.1.0 ./gradlew publishToMavenLocal
```

Publish to the local Maven repository:

```bash
ANDROID_HOME=/Users/akin/Library/Android/sdk ANDROID_SDK_ROOT=/Users/akin/Library/Android/sdk ./gradlew publishToMavenLocal
```

Publish a snapshot or manually staged release to Maven Central:

```bash
ORG_GRADLE_PROJECT_mavenCentralUsername=<central-token-username> \
ORG_GRADLE_PROJECT_mavenCentralPassword=<central-token-password> \
ORG_GRADLE_PROJECT_signingInMemoryKey=<ascii-armored-private-key> \
ORG_GRADLE_PROJECT_signingInMemoryKeyId=<gpg-key-id> \
ORG_GRADLE_PROJECT_signingInMemoryKeyPassword=<gpg-key-password> \
./gradlew publishToMavenCentral
```

Remote publishing uses Maven Central's Central Portal. Release deployments are uploaded for manual publishing from the Central Portal because automatic release is disabled by default.

## GitHub Actions

The manual `Publish Maven Central` workflow accepts a `version` input and expects these repository secrets:

- `MAVEN_CENTRAL_USERNAME`
- `MAVEN_CENTRAL_PASSWORD`
- `SIGNING_IN_MEMORY_KEY`
- `SIGNING_IN_MEMORY_KEY_ID`
- `SIGNING_IN_MEMORY_KEY_PASSWORD`
