package com.migrosone.sanalmarket.android.ui.sdk.compose

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.migrosone.sanalmarket.android.ui.sdk.compose.checkboxes.MigrosCheckbox
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MigrosCheckboxTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun migrosCheckboxReflectsCheckedState() {
        composeRule.setMigrosContent {
            MigrosCheckbox(
                isChecked = true,
                modifier = Modifier.testTag("checked-checkbox"),
                onCheckedChanged = {},
            )
        }

        composeRule.onNodeWithTag("checked-checkbox").assertIsOn()
    }

    @Test
    fun migrosCheckboxReflectsUncheckedState() {
        composeRule.setMigrosContent {
            MigrosCheckbox(
                isChecked = false,
                modifier = Modifier.testTag("unchecked-checkbox"),
                onCheckedChanged = {},
            )
        }

        composeRule.onNodeWithTag("unchecked-checkbox").assertIsOff()
    }

    @Test
    fun migrosCheckboxInvokesCheckedChange() {
        var changedValue: Boolean? = null

        composeRule.setMigrosContent {
            MigrosCheckbox(
                isChecked = false,
                modifier = Modifier.testTag("clickable-checkbox"),
                onCheckedChanged = { changedValue = it },
            )
        }

        composeRule.onNodeWithTag("clickable-checkbox").performClick()

        assertEquals(true, changedValue)
    }

    @Test
    fun migrosCheckboxReflectsDisabledState() {
        composeRule.setMigrosContent {
            MigrosCheckbox(
                isChecked = false,
                modifier = Modifier.testTag("disabled-checkbox"),
                onCheckedChanged = {},
                isEnabled = false,
            )
        }

        composeRule.onNodeWithTag("disabled-checkbox").assertIsNotEnabled()
    }
}
