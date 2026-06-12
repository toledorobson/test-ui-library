package com.migrosone.sanalmarket.android.ui.sdk.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosCompanyType
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosTheme

internal fun ComposeContentTestRule.setMigrosContent(
    companyType: MigrosCompanyType = MigrosCompanyType.SANALMARKET,
    content: @Composable () -> Unit,
) {
    setContent {
        MigrosTheme(companyType = companyType) {
            content()
        }
    }
}
