---
name: ui-library-component-authoring
description: Author, refactor, or review public Jetpack Compose components in this Sanalmarket Android UI SDK. Use when changing :ui-compose components, component previews, resources, sample catalog entries, or Compose UI tests for reusable library UI.
---

# UI Library Component Authoring

## Goal

Add or change reusable Compose components without drifting from this SDK's API, theme, sample, accessibility, and verification conventions.

## Workflow

1. Inspect the closest existing component under `ui-compose/src/main/kotlin/com/migrosone/sanalmarket/android/ui/sdk/compose`.
2. Confirm the change belongs in `:ui-compose`; put tokens in `:ui-theme` and demos only in `:sample`.
3. Design the public API before editing and avoid source-breaking changes unless requested.
4. Implement with Material3 primitives, `MigrosTheme`, `Dimens`, and localized resources.
5. Add previews, sample catalog coverage, and tests for meaningful states.

## Public API Contract

- Use package `com.migrosone.sanalmarket.android.ui.sdk.compose.<category>`.
- Prefer parameter order: required values/state, required callbacks, `modifier: Modifier = Modifier`, optional styling/behavior defaults.
- Keep components stateless; pass state down and events up.
- Apply `modifier` to the root layout or root Material component.
- Use `MigrosTheme.colors`, `MigrosTheme.typography`, and `Dimens` instead of hardcoded styling.
- Keep brand-specific defaults inside the component via theme tokens or `MigrosTheme.currentCompany`.
- Keep helpers `private` or `internal` unless consumers need them.

## Resources And Semantics

- Prefix `:ui-compose` resources with `sanalmarket_android_ui_sdk_compose_`.
- Put reusable component strings in `ui-compose/src/main/res/values/strings.xml`.
- Put sample-only labels in `sample/src/main/res/values/strings.xml`.
- Give actionable icons localized content descriptions; use `contentDescription = null` for decorative icons.
- Prefer semantic test queries over public `testTag` parameters.

## Previews And Sample

- Add private previews wrapped in `MigrosTheme`.
- Use `@PreviewParameter(MigrosCompanyTypePreviewParameterProvider::class)` when company colors or behavior can vary.
- Preview enabled, disabled, selected, checked, loading, error, or other important states.
- Update `SampleCatalog.kt` and sample strings when adding or materially changing a public component.
- Keep demo state local with `rememberSaveable` only when the sample needs interaction.

## Tests And Verification

- Add Compose UI tests for displayed content, click callbacks, disabled behavior, state semantics, and content descriptions.
- Wrap tests in `MigrosTheme(companyType = MigrosCompanyType.SANALMARKET)`.
- For component changes, run:

```bash
./gradlew :ui-compose:compileDebugKotlin :ui-compose:compileDebugAndroidTestKotlin
```

- If sample or resources changed, also run:

```bash
./gradlew :sample:assembleDebug
```
