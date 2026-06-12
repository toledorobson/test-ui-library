package com.migrosone.sanalmarket.android.ui.sdk.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

data class MigrosTypography(
    val Display1: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = Dimens.fontDisplay,
        lineHeight = Dimens.lineHeightDisplay
    ),

    val Display2: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = Dimens.fontMassive,
        lineHeight = Dimens.lineHeightXLarge
    ),

    val Display3: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = Dimens.fontLarger,
        lineHeight = Dimens.lineHeightMedium
    ),

    val H1: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = Dimens.fontHuge,
        lineHeight = Dimens.lineHeightLarge
    ),

    val H2: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = Dimens.fontLargest,
        lineHeight = Dimens.lineHeightMedium
    ),

    val H3: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = Dimens.fontLargest,
        lineHeight = Dimens.lineHeightMedium
    ),

    val Subtitle1: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = Dimens.fontLarge,
        lineHeight = Dimens.lineHeightMedium
    ),

    val Subtitle2: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = Dimens.fontNormal,
        lineHeight = Dimens.fontExtraLargest
    ),

    val Body1: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = Dimens.fontLarge,
        lineHeight = Dimens.lineHeightMedium
    ),

    val Body2: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = Dimens.fontNormal,
        lineHeight = Dimens.lineHeightSmall
    ),

    val Body3: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = Dimens.fontNormal,
        lineHeight = Dimens.lineHeightSmall
    ),

    val BodyUnderline: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = Dimens.fontNormal,
        lineHeight = Dimens.lineHeightSmall,
        textDecoration = TextDecoration.Underline
    ),

    val Caption1: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = Dimens.fontSmall,
        lineHeight = Dimens.lineHeightTiny
    ),

    val Caption2: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = Dimens.fontSmall,
        lineHeight = Dimens.lineHeightTiny
    ),

    val Caption3: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = Dimens.fontSmall,
        lineHeight = Dimens.lineHeightTiny
    ),

    val CaptionUnderline: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = Dimens.fontSmall,
        lineHeight = Dimens.lineHeightTiny,
        textDecoration = TextDecoration.Underline
    ),


    val Overline1: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = Dimens.fontSmallest,
        lineHeight = Dimens.lineHeightExtraTiny
    ),

    val Overline2: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = Dimens.fontSmallest,
        lineHeight = Dimens.lineHeightExtraTiny,
        color = TextColors.textBody
    ),

    val Overline3: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = Dimens.fontSmallest,
        lineHeight = Dimens.lineHeightExtraTiny
    ),

    val Overline5: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = Dimens.fontVeryTiny,
        lineHeight = Dimens.lineHeightMicro
    ),

    val OverlineUnderline: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = Dimens.fontSmallest,
        lineHeight = Dimens.lineHeightExtraTiny,
        textDecoration = TextDecoration.Underline
    ),

    val SMRegular: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = Dimens.fontVeryTiny,
        lineHeight = Dimens.lineHeightMicro
    ),

    val SMMedium: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = Dimens.fontVeryTiny,
        lineHeight = Dimens.lineHeightMicro
    ),

    val ButtonSmall: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = Dimens.fontSmall,
        lineHeight = Dimens.lineHeightMicro
    ),

    val ButtonMedium: TextStyle = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = Dimens.fontNormal,
        lineHeight = Dimens.lineHeightExtraTiny
    )
)

val Inter = FontFamily(
    Font(R.font.inter_thin, FontWeight.Thin),
    Font(R.font.inter_extralight, FontWeight.ExtraLight),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extrabold, FontWeight.ExtraBold)
)

val Nunito = FontFamily(
    Font(R.font.nunito_black, FontWeight.Black),
    Font(R.font.nunito_medium, FontWeight.Medium)
)
