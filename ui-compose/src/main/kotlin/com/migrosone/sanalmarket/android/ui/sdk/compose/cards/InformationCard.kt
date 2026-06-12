package com.migrosone.sanalmarket.android.ui.sdk.compose.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.migrosone.sanalmarket.android.ui.sdk.compose.R
import com.migrosone.sanalmarket.android.ui.sdk.theme.Dimens
import com.migrosone.sanalmarket.android.ui.sdk.theme.InfoColors
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosCompanyType
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosTheme

@Composable
fun InformationCard(modifier: Modifier, infoText: String) {
    Row(
        modifier
            .fillMaxWidth()
            .background(
                color = InfoColors.FillColor,
                shape = RoundedCornerShape(Dimens.radiusMedium)
            )
            .padding(Dimens.spacingSmall)
    ) {
        Image(
            modifier = Modifier
                .size(Dimens.dp_16),
            painter = painterResource(R.drawable.sanalmarket_android_ui_sdk_compose_ic_info),
            contentDescription = null
        )
        Spacer(Modifier.size(Dimens.spacingSmall))
        Text(text = infoText, style = MigrosTheme.typography.Caption1)
    }
}

@Preview(showBackground = true)
@Composable
private fun InformationCardPreview() {
    MigrosTheme(companyType = MigrosCompanyType.SANALMARKET) {
        InformationCard(
            modifier = Modifier.padding(Dimens.spacingSmaller),
            infoText = "Poliçen Eureko Sigorta tarafından SMS ile gönderilecek."
        )
    }
}
