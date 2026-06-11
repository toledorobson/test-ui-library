package com.migrosone.uilibrary.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.migrosone.uilibrary.theme.Dimens
import com.migrosone.uilibrary.theme.MigrosCompanyType
import com.migrosone.uilibrary.theme.MigrosCompanyTypePreviewParameterProvider
import com.migrosone.uilibrary.theme.MigrosTheme

@Composable
fun MigrosButton(
    buttonText: String,
    buttonOnClickAction: () -> Unit,
    modifier: Modifier = Modifier,
    radius: Dp = Dimens.radiusSmall,
    isEnabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MigrosTheme.colors.colorPrimary,
        contentColor = MigrosTheme.colors.colorOnSurface
    )
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimens.migrosButtonHeight),
        onClick = buttonOnClickAction,
        colors = colors,
        enabled = isEnabled,
        shape = RoundedCornerShape(radius),
        contentPadding = PaddingValues(Dimens.spacingNormal, Dimens.spacingZero)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = buttonText,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MigrosTheme.typography.ButtonMedium.copy(
                letterSpacing = TextUnit(Dimens.migrosButtonLetterSpacing, TextUnitType.Em)
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun MigrosButtonPreview(
    @PreviewParameter(MigrosCompanyTypePreviewParameterProvider::class) companyType: MigrosCompanyType
) {
    MigrosTheme(companyType) {
        MigrosButton(
            buttonText = "Gönder",
            buttonOnClickAction = {}
        )
    }
}
