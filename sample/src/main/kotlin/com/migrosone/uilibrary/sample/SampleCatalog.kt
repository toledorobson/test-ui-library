package com.migrosone.uilibrary.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.migrosone.uilibrary.compose.buttons.AddToCartPlusButton
import com.migrosone.uilibrary.compose.buttons.CampaignEnrollButton
import com.migrosone.uilibrary.compose.buttons.CloseButton
import com.migrosone.uilibrary.compose.buttons.MigrosButton
import com.migrosone.uilibrary.compose.buttons.MigrosButtonOutlined
import com.migrosone.uilibrary.theme.Dimens
import com.migrosone.uilibrary.compose.R as ComposeR

internal fun sampleComponentSections(): List<ComponentSection> = listOf(
    ComponentSection(
        titleRes = R.string.sample_section_buttons,
        samples = listOf(
            ComponentSample(
                titleRes = R.string.sample_migros_button_title,
                descriptionRes = R.string.sample_migros_button_description,
            ) {
                MigrosButton(
                    buttonText = stringResource(R.string.sample_button_text),
                    buttonOnClickAction = {},
                    modifier = Modifier.fillMaxWidth(),
                )
            },
            ComponentSample(
                titleRes = R.string.sample_migros_button_outlined_title,
                descriptionRes = R.string.sample_migros_button_outlined_description,
            ) {
                MigrosButtonOutlined(
                    buttonText = stringResource(R.string.sample_button_text),
                    buttonOnClickAction = {},
                    modifier = Modifier.fillMaxWidth(),
                )
            },
            ComponentSample(
                titleRes = R.string.sample_add_to_cart_plus_button_title,
                descriptionRes = R.string.sample_add_to_cart_plus_button_description,
            ) {
                AddToCartPlusButton(onClick = {})
            },
            ComponentSample(
                titleRes = R.string.sample_campaign_enroll_button_title,
                descriptionRes = R.string.sample_campaign_enroll_button_description,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(Dimens.spacingSmall),
                ) {
                    CampaignEnrollButton(
                        onActionClick = {},
                        buttonText = stringResource(R.string.sample_campaign_enroll_button_text),
                        enrolled = false,
                        icon = ComposeR.drawable.migrosone_ui_compose_ic_plus,
                    )
                    CampaignEnrollButton(
                        onActionClick = {},
                        buttonText = stringResource(R.string.sample_campaign_enroll_button_text),
                        enrolled = true,
                        icon = ComposeR.drawable.migrosone_ui_compose_ic_plus,
                    )
                }
            },
            ComponentSample(
                titleRes = R.string.sample_close_button_title,
                descriptionRes = R.string.sample_close_button_description,
            ) {
                CloseButton(onDismiss = {})
            },
        ),
    ),
)
