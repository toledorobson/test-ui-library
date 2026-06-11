package com.migrosone.uilibrary.compose.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.migrosone.uilibrary.theme.Dimens
import com.migrosone.uilibrary.theme.MigrosCompanyType
import com.migrosone.uilibrary.theme.MigrosCompanyTypePreviewParameterProvider
import com.migrosone.uilibrary.theme.MigrosTheme

@Composable
fun MigrosButtonOutlined(
    buttonText: String,
    buttonOnClickAction: () -> Unit,
    modifier: Modifier = Modifier,
    iconRes: Int? = null
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimens.migrosButtonHeight),
        onClick = buttonOnClickAction,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = MigrosTheme.colors.colorPrimary
        ),
        shape = RoundedCornerShape(Dimens.radiusSmall),
        border = BorderStroke(Dimens.dp_1, color = MigrosTheme.colors.colorSecondary),
        contentPadding = PaddingValues(Dimens.spacingNormal, Dimens.spacingZero)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if (iconRes != null) {
                Image(
                    modifier = Modifier
                        .padding(end = Dimens.spacingSlightlySmall)
                        .size(Dimens.dp_16),
                    painter = painterResource(iconRes),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MigrosTheme.colors.colorSecondary)
                )
            }
            Text(
                text = buttonText,
                color = MigrosTheme.colors.colorSecondary,
                textAlign = TextAlign.Center,
                style = MigrosTheme.typography.ButtonMedium.copy(
                    letterSpacing = TextUnit(Dimens.migrosButtonLetterSpacing, TextUnitType.Em)
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun MigrosButtonPreview(
    @PreviewParameter(MigrosCompanyTypePreviewParameterProvider::class) companyType: MigrosCompanyType
) {
    MigrosTheme(companyType = (companyType)) {
        MigrosButtonOutlined(
            buttonText = "Gönder",
            buttonOnClickAction = {}
        )
    }
}