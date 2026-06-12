package com.migrosone.sanalmarket.android.ui.sdk.theme

internal fun MigrosCompanyType.toThemeColors(): BaseThemeColors {
    return when (this) {
        MigrosCompanyType.SANALMARKET -> BaseThemeColors.SanalMarketThemeColors()
        MigrosCompanyType.ELEKTRONIK -> BaseThemeColors.EkstraThemeColors()
        MigrosCompanyType.KURBAN -> BaseThemeColors.KurbanThemeColors()
        MigrosCompanyType.HEMEN -> BaseThemeColors.HemenThemeColors()
        MigrosCompanyType.YEMEK -> BaseThemeColors.YemekThemeColors()
        MigrosCompanyType.TAZEDIREKT -> BaseThemeColors.TazeDirektThemeColors()
        MigrosCompanyType.MACROCENTER -> BaseThemeColors.MacroOnlineThemeColors()
        MigrosCompanyType.MION -> BaseThemeColors.MionThemeColors()
        MigrosCompanyType.LOTTERY -> BaseThemeColors.LotteryThemeColors()
        MigrosCompanyType.PET -> BaseThemeColors.PetimoThemeColors()
    }
}
