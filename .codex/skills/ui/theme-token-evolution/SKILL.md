---
name: theme-token-evolution
description: Change or review theme tokens in this Android UI SDK. Use when updating :ui-theme colors, company theme mappings, typography, dimensions, fonts, MigrosTheme behavior, previews, or tests for brand-specific design tokens.
---

# Theme Token Evolution

## Goal

Evolve `:ui-theme` tokens without breaking company-specific branding or reusable component defaults in `:ui-compose`.

## Workflow

1. Identify whether the change affects colors, typography, dimensions, fonts, company mapping, or `MigrosTheme` composition locals.
2. Inspect the nearest token file and all call sites in `:ui-compose` before editing.
3. Keep public token names stable unless a rename is explicitly required.
4. Update tests or previews for every company-specific behavior that changes.
5. Run focused theme verification before broader sample verification.

## Token Rules

- Put brand colors and theme color implementations in `MigrosColor.kt` and company mapping in `MigrosCompanyTypeThemeColors.kt`.
- Put spacing, radius, size, and component dimensions in `MigrosDimen.kt`.
- Put typography and font-family behavior in `MigrosType.kt` and font resources under `ui-theme/src/main/res/font`.
- Keep `MigrosTheme.colors`, `MigrosTheme.typography`, and `MigrosTheme.dimens` as the component-facing API.
- Do not replace SDK tokens with direct Material theme token access in library components.
- Treat `MigrosCompanyType` additions or removals as public API changes; update mappings, previews, and tests together.

## Cross-Module Checks

- Search `:ui-compose` for every token changed and confirm visual defaults still make sense.
- Update component previews when token changes alter visible states.
- Keep sample-only styling out of `:ui-theme`.
- Avoid adding a dependency to `:ui-theme` unless tokens cannot be represented with Compose UI or Material3 primitives already present.

## Tests And Verification

- Update `MigrosCompanyTypeThemeColorsTest` for changed company color behavior.
- Add unit coverage for new token mapping logic when it can be tested without rendering.
- For theme-only changes, run:

```bash
./gradlew :ui-theme:testDebugUnitTest :ui-theme:compileDebugKotlin
```

- If component visuals or sample catalog output can change, also run:

```bash
./gradlew :ui-compose:compileDebugKotlin :sample:assembleDebug
```
