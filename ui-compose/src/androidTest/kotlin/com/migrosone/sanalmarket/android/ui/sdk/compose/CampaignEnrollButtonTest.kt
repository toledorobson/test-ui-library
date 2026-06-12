package com.migrosone.sanalmarket.android.ui.sdk.compose

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.migrosone.sanalmarket.android.ui.sdk.compose.buttons.CampaignEnrollButton
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class CampaignEnrollButtonTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun campaignEnrollButtonShowsEnabledActionWhenNotEnrolled() {
        composeRule.setMigrosContent {
            CampaignEnrollButton(
                onActionClick = {},
                buttonText = "Kampanyaya Katıl",
                enrolled = false,
            )
        }

        composeRule
            .onNodeWithText("Kampanyaya Katıl")
            .assertIsDisplayed()
            .assertIsEnabled()
    }

    @Test
    fun campaignEnrollButtonInvokesActionWhenNotEnrolled() {
        var clickCount = 0

        composeRule.setMigrosContent {
            CampaignEnrollButton(
                onActionClick = { clickCount++ },
                buttonText = "Kampanyaya Katıl",
                enrolled = false,
            )
        }

        composeRule.onNodeWithText("Kampanyaya Katıl").performClick()

        assertEquals(1, clickCount)
    }

    @Test
    fun campaignEnrollButtonShowsDisabledSuccessWhenEnrolled() {
        composeRule.setMigrosContent {
            CampaignEnrollButton(
                onActionClick = {},
                buttonText = "Kampanyaya Katıl",
                enrolled = true,
            )
        }

        composeRule
            .onNodeWithText("Money Kartına Eklendi")
            .assertIsDisplayed()
            .assertIsNotEnabled()
        composeRule.onAllNodesWithText("Kampanyaya Katıl").assertCountEquals(0)
    }
}
