package com.migrosone.sanalmarket.android.ui.sdk.compose

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.migrosone.sanalmarket.android.ui.sdk.compose.cards.InformationCard
import org.junit.Rule
import org.junit.Test

class InformationCardTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun informationCardShowsInfoText() {
        composeRule.setMigrosContent {
            InformationCard(
                modifier = Modifier,
                infoText = "Poliçen SMS ile gönderilecek.",
            )
        }

        composeRule
            .onNodeWithText("Poliçen SMS ile gönderilecek.")
            .assertIsDisplayed()
    }
}
