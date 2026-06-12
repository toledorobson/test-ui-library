---
name: gradle-build-performance
description: Debug and optimize Gradle build performance for this Android UI SDK. Use when :sample, :ui-compose, :ui-theme, build-logic, CI verification, build scans, configuration time, or incremental compilation is slow.
---

# Gradle Build Performance

## Goal

Measure first, change one thing, then re-measure. Keep optimizations compatible with this library's publishable modules and included `build-logic` convention plugins.

## Repo Shape

- `:ui-compose` and `:ui-theme` are publishable Android library modules.
- `:sample` is the verification/demo app.
- `build-logic/convention` supplies Android and publishing convention plugins.
- `gradle.properties` already enables parallel builds, AndroidX, non-transitive R classes, and a 4 GB Gradle heap.

## Workflow

1. Capture the exact slow command and whether it is clean, incremental, local, or CI.
2. Run a baseline with the same command before changing build files.
3. Use `--scan` or `--profile` to classify the bottleneck as configuration, dependency resolution, Kotlin/Android compilation, tests, lint, or publishing.
4. Inspect only the relevant build scripts, convention plugin, or version catalog.
5. Apply one optimization per iteration and re-run the same command.

## Diagnostics

Use commands that match the complaint:

```bash
./gradlew :sample:assembleDebug --profile
./gradlew :ui-compose:compileDebugKotlin --profile
./gradlew :ui-theme:testDebugUnitTest --profile
```

Use `--scan` when build scan publication is acceptable. Do not make build-scan terms or remote-cache changes without explicit intent.

## Optimization Rules

- Prefer lazy Gradle APIs: `tasks.register`, providers, and plugin configuration blocks.
- Avoid configuration-time file I/O, environment reads that cannot be cached, and dynamic dependency versions.
- Keep dependency changes in `gradle/libs.versions.toml`; avoid module-local version literals.
- Use `implementation` unless an API type is exposed to consumers.
- Do not enable configuration cache, build cache, or remote cache blindly; first verify current plugin compatibility and expected benefit.
- Treat publishing changes as high risk because `:ui-compose` and `:ui-theme` use Maven Central metadata and signing credentials.

## Verification

For local build-script changes, run the affected command plus:

```bash
./gradlew -q help
```

For changes touching publishable modules or convention plugins, run:

```bash
./gradlew :sample:assembleDebug :ui-theme:testDebugUnitTest :ui-compose:testDebugUnitTest lintDebug
```

Report baseline time, after time, and the build phase that changed. If timing data is unavailable, say so and report only compile/verification status.
