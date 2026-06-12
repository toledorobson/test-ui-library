---
name: compose-performance-audit
description: Audit Jetpack Compose runtime performance in this Android UI SDK. Use when diagnosing janky scrolling, slow reusable components, excessive recompositions, unstable parameters, lazy list performance, or expensive work inside :ui-compose or :sample composables.
---

# Compose Performance Audit

## Goal

Find the smallest code or architecture change that improves Compose runtime performance without weakening the public component API.

## Workflow

1. Start from the affected component or sample screen.
2. Identify the symptom: janky scroll, delayed click response, repeated recomposition, slow first draw, or unnecessary allocation.
3. Review state ownership, parameter stability, lazy list identity, and work done during composition.
4. Prefer code evidence first; request Layout Inspector, recomposition counts, or Perfetto only when code review is inconclusive.
5. Apply one targeted fix at a time and explain the expected performance effect.

## Review Checklist

- Keep public components stateless; pass state down and events up.
- Avoid sorting, filtering, formatting, object construction, or resource-heavy work inside composition unless wrapped in `remember` with correct keys.
- Use stable item keys in `LazyColumn` and `LazyRow`.
- Avoid reading rapidly changing state high in the tree; defer reads with lambda modifiers, `derivedStateOf`, layout-phase reads, or draw-phase reads where appropriate.
- Check whether parameters are stable enough for reusable components; use `@Immutable` only when the type is genuinely immutable.
- Keep modifier chains simple and avoid intrinsic measurements or deep nested layouts unless the component needs them.
- Size images/icons explicitly and keep decorative images out of semantics.

## Fix Guidance

- Keep fixes local to the component or sample unless shared architecture is the root cause.
- Do not add a new dependency for performance unless measurement justifies it.
- Avoid changing public parameters solely for performance unless the old API blocks a correct fix.
- If a sample screen owns demo state, keep the state local and cheap with `rememberSaveable` only when persistence is useful.

## Verification

Use the narrowest useful verification:

```bash
./gradlew :ui-compose:compileDebugKotlin
```

If Android test semantics or sample behavior changed, also run:

```bash
./gradlew :ui-compose:compileDebugAndroidTestKotlin :sample:assembleDebug
```

For measured performance work, report before/after evidence when available: recomposition counts, trace observations, frame timing, or a clear code-level reason when measurement is not available.
