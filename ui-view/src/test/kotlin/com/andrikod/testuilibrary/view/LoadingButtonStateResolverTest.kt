package com.andrikod.testuilibrary.view

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LoadingButtonStateResolverTest {
    @Test
    fun loadingStateUsesLoadingTextAndDisablesInteraction() {
        val state = LoadingButtonStateResolver.resolve(
            text = "Save",
            loadingText = "Saving",
            isLoading = true,
            enabled = true,
        )

        assertEquals("Saving", state.displayText)
        assertFalse(state.isInteractionEnabled)
    }

    @Test
    fun loadingStateFallsBackToTextWhenNoLoadingTextIsSet() {
        val state = LoadingButtonStateResolver.resolve(
            text = "Save",
            loadingText = null,
            isLoading = true,
            enabled = true,
        )

        assertEquals("Save", state.displayText)
        assertFalse(state.isInteractionEnabled)
    }

    @Test
    fun idleStateKeepsEnabledFlag() {
        val state = LoadingButtonStateResolver.resolve(
            text = "Save",
            loadingText = "Saving",
            isLoading = false,
            enabled = true,
        )

        assertEquals("Save", state.displayText)
        assertTrue(state.isInteractionEnabled)
    }
}
