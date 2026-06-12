package com.migrosone.sanalmarket.android.ui.sdk.compose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.migrosone.sanalmarket.android.ui.sdk.compose.buttons.AddToCartPlusButton
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosCompanyType
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosTheme
import org.junit.Rule
import org.junit.Test

class AddToCartPlusButtonTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun addToCartPlusButtonShowsAddToCartContentDescription() {
        composeRule.setContent {
            MigrosTheme(companyType = MigrosCompanyType.SANALMARKET) {
                AddToCartPlusButton(onClick = {})
            }
        }

        composeRule
            .onNodeWithContentDescription("Add to cart")
            .assertIsDisplayed()
    }
}
