package com.migrosone.sanalmarket.android.ui.sdk.compose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.migrosone.sanalmarket.android.ui.sdk.compose.buttons.MigrosButtonOutlined
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MigrosButtonOutlinedTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun migrosButtonOutlinedShowsText() {
        composeRule.setMigrosContent {
            MigrosButtonOutlined(
                buttonText = "Devam",
                buttonOnClickAction = {},
            )
        }

        composeRule.onNodeWithText("Devam").assertIsDisplayed()
    }

    @Test
    fun migrosButtonOutlinedInvokesClickAction() {
        var clickCount = 0

        composeRule.setMigrosContent {
            MigrosButtonOutlined(
                buttonText = "Seç",
                buttonOnClickAction = { clickCount++ },
            )
        }

        composeRule.onNodeWithText("Seç").performClick()

        assertEquals(1, clickCount)
    }

    @Test
    fun migrosButtonOutlinedShowsTextWithOptionalIcon() {
        composeRule.setMigrosContent {
            MigrosButtonOutlined(
                buttonText = "Ekle",
                buttonOnClickAction = {},
                iconRes = R.drawable.sanalmarket_android_ui_sdk_compose_ic_plus,
            )
        }

        composeRule.onNodeWithText("Ekle").assertIsDisplayed()
    }
}
