---
name: android-accessibility
description: Audit and fix Android accessibility for this Compose UI SDK. Use when adding or reviewing component semantics, content descriptions, touch targets, contrast, state announcements, focus order, or Compose UI accessibility tests.
---

# Android Accessibility

## Goal

Make reusable components usable with TalkBack, keyboard focus, and Compose UI tests without exposing unnecessary API.

## Checklist

- Give actionable icons a localized action description from `ui-compose/src/main/res/values/strings.xml`.
- Use `contentDescription = null` for decorative `Icon` or `Image` content.
- Keep interactive targets at least 48dp in both dimensions; expand the hit target even when the visual icon is smaller.
- Preserve standard Material semantics for `Button`, `Checkbox`, and similar controls unless custom behavior requires explicit semantics.
- Use `stateDescription` only for custom states that standard semantics do not announce clearly.
- Merge descendants for compound clickable rows/cards when the item should be announced as one action.
- Mark section titles as headings in screen-level sample/catalog UI when that improves traversal.
- Check color contrast when changing text, icon, border, or container colors in `:ui-compose` or `:ui-theme`.

## SDK Conventions

- Prefer user-visible semantics over public `testTag` parameters.
- Add a `testTag` parameter only when semantics cannot identify the target and the API impact is acceptable.
- Keep sample-only descriptions in `sample/src/main/res/values/strings.xml`; keep reusable component descriptions in `:ui-compose`.
- Do not describe decorative brand styling or layout-only imagery to screen readers.

## Tests

Add or update Compose UI tests when accessibility behavior changes:

- Query actionable icons by content description.
- Assert enabled, disabled, checked, selected, or custom state behavior.
- Verify click callbacks for custom clickable containers.
- Avoid tests that depend on purely decorative nodes.

Run at least:

```bash
./gradlew :ui-compose:compileDebugAndroidTestKotlin
```
