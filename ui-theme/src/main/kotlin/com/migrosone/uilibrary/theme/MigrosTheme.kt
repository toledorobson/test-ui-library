package com.migrosone.uilibrary.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Don't use MaterialTheme.colors use MigrosTheme.colors because MaterialTheme is default
 * Wrap the content with MigrosTheme to use MigrosTheme correctly.
 *
 * Sample usage:
 * ```kotlin
 * @Composable
 * fun MigrosThemeSample() {
 *     MigrosTheme(companyType = MigrosCompanyType.SANALMARKET) {
 *         Text(
 *             text = "How to Use Migros Theme",
 *             style = MigrosTheme.typography.BodyUnderline,
 *             color = MigrosTheme.colors.colorPrimary
 *         )
 *     }
 * }
 * ```
 */

@Composable
fun MigrosTheme(
    companyType: MigrosCompanyType,
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val companyColorTheme = remember(companyType) {
        companyType.toThemeColors()
    }

    /**
     * We are using Material Theme because the Material3 views internally are based on MaterialTheme.
     */

    CompositionLocalProvider(
        LocalMigrosColor provides companyColorTheme,
        LocalMigrosTypography provides MigrosTypography(),
        LocalMigrosDimens provides Dimens,
        LocalCurrentCompany provides companyType
    ) {
        MaterialTheme(
            content = content
        )
    }
}

@SuppressLint("CompositionLocalNaming")
private val LocalMigrosColor =
    staticCompositionLocalOf<BaseThemeColors> { error("No MigrosColor provided") }
private val LocalMigrosTypography =
    staticCompositionLocalOf<MigrosTypography> { error("No MigrosTypography provided") }
private val LocalMigrosDimens =
    staticCompositionLocalOf<Dimens> { error("No MigrosDimens provided") }

private val LocalCurrentCompany =
    staticCompositionLocalOf<MigrosCompanyType> { error("No MigrosCompanyType provided") }

object MigrosTheme {
    val colors: BaseThemeColors
        @Composable
        get() = LocalMigrosColor.current

    val typography: MigrosTypography
        @Composable
        get() = LocalMigrosTypography.current

    val dimens: Dimens
        @Composable
        get() = LocalMigrosDimens.current

    val currentCompany: MigrosCompanyType
        @Composable
        get() = LocalCurrentCompany.current
}
