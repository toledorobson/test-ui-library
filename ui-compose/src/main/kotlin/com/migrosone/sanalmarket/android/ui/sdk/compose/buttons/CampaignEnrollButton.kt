package com.migrosone.sanalmarket.android.ui.sdk.compose.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.migrosone.sanalmarket.android.ui.sdk.compose.R
import com.migrosone.sanalmarket.android.ui.sdk.theme.BasicColors.Basic100
import com.migrosone.sanalmarket.android.ui.sdk.theme.BasicColors.Basic300
import com.migrosone.sanalmarket.android.ui.sdk.theme.BasicColors.Basic700
import com.migrosone.sanalmarket.android.ui.sdk.theme.BasicColors.Basic800
import com.migrosone.sanalmarket.android.ui.sdk.theme.Dimens
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosCompanyType
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosTheme

@Composable
fun CampaignEnrollButton(
    onActionClick: () -> Unit,
    buttonText: String,
    enrolled: Boolean,
    modifier: Modifier = Modifier,
    icon: Int? = null,
) {
    Button(
        onClick = onActionClick,
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = if (enrolled) Basic100 else Color.White,
            disabledContainerColor = Basic100
        ),
        border = if (enrolled) {
            BorderStroke(width = Dimens.strokeThin, Basic800)
        } else {
            BorderStroke(width = Dimens.strokeThin, Basic300)
        },
        enabled = enrolled.not()
    ) {
        if (icon != null) {
            if (enrolled) {
                Icon(
                    painter = painterResource(R.drawable.sanalmarket_android_ui_sdk_compose_ic_check),
                    contentDescription = null,
                    tint = Basic800,
                    modifier = Modifier.size(Dimens.spacingNormal)
                )
            } else {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    tint = Basic700
                )
            }
            Spacer(modifier = Modifier.width(Dimens.spacingTiny))
        }
        Text(
            text = if (enrolled) {
                stringResource(R.string.sanalmarket_android_ui_sdk_compose_student_tbg_campaigns_button_verified_success)
            } else {
                buttonText
            },
            color = Basic700
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CampaignEnrollButtonEnrolledPreview() {
    MigrosTheme(companyType = (MigrosCompanyType.SANALMARKET)) {
        CampaignEnrollButton(
            onActionClick = {},
            buttonText = "UniMoney’e Katıl",
            enrolled = true,
            icon = R.drawable.sanalmarket_android_ui_sdk_compose_ic_plus
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CampaignEnrollButtonNotEnrolledPreview() {
    MigrosTheme(companyType = (MigrosCompanyType.SANALMARKET)) {
        CampaignEnrollButton(
            onActionClick = {},
            buttonText = "UniMoney’e Katıl",
            enrolled = false,
            icon = R.drawable.sanalmarket_android_ui_sdk_compose_ic_plus
        )
    }
}
