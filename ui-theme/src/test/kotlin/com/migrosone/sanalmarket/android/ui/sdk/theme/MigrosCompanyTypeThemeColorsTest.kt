package com.migrosone.sanalmarket.android.ui.sdk.theme

import org.junit.Assert.assertEquals
import org.junit.Test

class MigrosCompanyTypeThemeColorsTest {
    @Test
    fun sanalMarketUsesSanalMarketPrimaryColor() {
        val colors = MigrosCompanyType.SANALMARKET.toThemeColors()

        assertEquals(SanalMarketColors.Primary700, colors.colorPrimary)
        assertEquals(SanalMarketColors.Primary700Transparent, colors.colorPrimaryTransparent)
    }

    @Test
    fun hemenUsesHemenPrimaryColor() {
        val colors = MigrosCompanyType.HEMEN.toThemeColors()

        assertEquals(HemenColors.Primary700, colors.colorPrimary)
        assertEquals(HemenColors.Primary700Transparent, colors.colorPrimaryTransparent)
    }

    @Test
    fun macrocenterUsesMacroOnlineThemeColors() {
        val colors = MigrosCompanyType.MACROCENTER.toThemeColors()

        assertEquals(Tab, colors.colorPrimary)
        assertEquals(MacroOnlineColors.Primary700Transparent, colors.colorPrimaryTransparent)
    }
}
