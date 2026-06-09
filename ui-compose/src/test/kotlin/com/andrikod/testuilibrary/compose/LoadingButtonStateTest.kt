package com.andrikod.testuilibrary.compose

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LoadingButtonStateTest {
    @Test
    fun loadingStateUsesLoadingTextAndDisablesInteraction() {
        val state = resolveLoadingButtonState(
            text = "Submit",
            loadingText = "Submitting",
            isLoading = true,
            enabled = true,
        )

        assertEquals("Submitting", state.displayText)
        assertFalse(state.isInteractionEnabled)
    }

    @Test
    fun loadingStateFallsBackToNormalText() {
        val state = resolveLoadingButtonState(
            text = "Submit",
            loadingText = null,
            isLoading = true,
            enabled = true,
        )

        assertEquals("Submit", state.displayText)
        assertFalse(state.isInteractionEnabled)
    }

    @Test
    fun idleStateKeepsEnabledFlag() {
        val enabledState = resolveLoadingButtonState(
            text = "Submit",
            loadingText = "Submitting",
            isLoading = false,
            enabled = true,
        )
        val disabledState = resolveLoadingButtonState(
            text = "Submit",
            loadingText = "Submitting",
            isLoading = false,
            enabled = false,
        )

        assertTrue(enabledState.isInteractionEnabled)
        assertEquals("Submit", enabledState.displayText)
        assertFalse(disabledState.isInteractionEnabled)
    }
}
