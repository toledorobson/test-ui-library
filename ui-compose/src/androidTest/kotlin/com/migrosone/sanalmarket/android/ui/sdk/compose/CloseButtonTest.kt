package com.migrosone.sanalmarket.android.ui.sdk.compose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.migrosone.sanalmarket.android.ui.sdk.compose.buttons.CloseButton
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class CloseButtonTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun closeButtonShowsDefaultContentDescription() {
        composeRule.setMigrosContent {
            CloseButton(onDismiss = {})
        }

        composeRule
            .onNodeWithContentDescription("Kapat")
            .assertIsDisplayed()
    }

    @Test
    fun closeButtonShowsCustomContentDescription() {
        composeRule.setMigrosContent {
            CloseButton(
                onDismiss = {},
                closeContentDescription = "Paneli kapat",
            )
        }

        composeRule
            .onNodeWithContentDescription("Paneli kapat")
            .assertIsDisplayed()
    }

    @Test
    fun closeButtonAppliesTestTag() {
        composeRule.setMigrosContent {
            CloseButton(
                onDismiss = {},
                testTag = "close-button",
            )
        }

        composeRule
            .onNodeWithTag("close-button")
            .assertIsDisplayed()
    }

    @Test
    fun closeButtonInvokesDismissThroughLabeledNode() {
        var dismissCount = 0

        composeRule.setMigrosContent {
            CloseButton(onDismiss = { dismissCount++ })
        }

        composeRule.onNodeWithContentDescription("Kapat").performClick()

        assertEquals(1, dismissCount)
    }
}
