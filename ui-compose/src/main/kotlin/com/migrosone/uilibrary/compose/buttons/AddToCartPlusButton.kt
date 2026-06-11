package com.migrosone.uilibrary.compose.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.migrosone.uilibrary.compose.R
import com.migrosone.uilibrary.theme.BasicColors
import com.migrosone.uilibrary.theme.Dimens
import com.migrosone.uilibrary.theme.MigrosCompanyType
import com.migrosone.uilibrary.theme.MigrosCompanyTypePreviewParameterProvider
import com.migrosone.uilibrary.theme.MigrosTheme

@Composable
fun AddToCartPlusButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val backgroundColor =
        if (MigrosTheme.currentCompany == MigrosCompanyType.HEMEN) BasicColors.Black else MigrosTheme.colors.colorPrimary
    Surface(
        modifier = modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(Dimens.radiusSmall),
        color = backgroundColor,
        contentColor = BasicColors.White,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(R.drawable.migrosone_ui_compose_ic_plus),
                contentDescription = stringResource(R.string.migrosone_ui_compose_button_label_add_to_cart),
                tint = BasicColors.White
            )
        }
    }
}

@Composable
@Preview
private fun AddToCartPlusButtonPreview(
    @PreviewParameter(MigrosCompanyTypePreviewParameterProvider::class) companyType: MigrosCompanyType
) {
    MigrosTheme(companyType = companyType) {
        AddToCartPlusButton(onClick = {})
    }
}
