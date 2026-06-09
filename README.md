# Test UI Library

An Android UI library starter inspired by Accompanist's library-first module layout and Now in Android's convention-plugin build structure.

## Modules

- `:ui-compose` exposes a Jetpack Compose `LoadingButton`.
- `:ui-view` exposes an XML/Kotlin `LoadingButtonView`.
- `:sample` demonstrates both implementations in a tabbed sample app.
- `build-logic/convention` contains shared Gradle convention plugins.

## Verify

```bash
ANDROID_HOME=/Users/akin/Library/Android/sdk ANDROID_SDK_ROOT=/Users/akin/Library/Android/sdk ./gradlew :sample:assembleDebug :ui-compose:testDebugUnitTest :ui-view:testDebugUnitTest lintDebug
```
