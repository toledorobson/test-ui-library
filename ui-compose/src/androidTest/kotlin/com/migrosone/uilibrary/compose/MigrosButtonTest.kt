package com.migrosone.uilibrary.compose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.migrosone.uilibrary.compose.buttons.MigrosButton
import com.migrosone.uilibrary.theme.MigrosCompanyType
import com.migrosone.uilibrary.theme.MigrosTheme
import org.junit.Rule
import org.junit.Test

class MigrosButtonTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun migrosButtonShowsTextInsideMigrosTheme() {
        composeRule.setContent {
            MigrosTheme(companyType = MigrosCompanyType.SANALMARKET) {
                MigrosButton(
                    buttonText = "Gönder",
                    buttonOnClickAction = {},
                )
            }
        }

        composeRule.onNodeWithText("Gönder").assertIsDisplayed()
    }

    @Test
    fun migrosButtonReflectsDisabledState() {
        composeRule.setContent {
            MigrosTheme(companyType = MigrosCompanyType.SANALMARKET) {
                MigrosButton(
                    buttonText = "Pasif",
                    buttonOnClickAction = {},
                    isEnabled = false,
                )
            }
        }

        composeRule.onNodeWithText("Pasif").assertIsNotEnabled()
    }
}
