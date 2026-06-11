package com.migrosone.uilibrary.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class LoadingButtonTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun loadingButtonShowsLoadingTextAndProgressIndicator() {
        composeRule.setContent {
            MaterialTheme {
                LoadingButton(
                    text = "Submit",
                    loadingText = "Submitting",
                    isLoading = true,
                    onClick = {},
                )
            }
        }

        composeRule.onNodeWithText("Submitting").assertIsDisplayed()
        composeRule.onNodeWithContentDescription("Loading").assertIsDisplayed()
    }
}
