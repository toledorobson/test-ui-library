package com.migrosone.sanalmarket.android.ui.sdk.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.migrosone.sanalmarket.android.ui.sdk.compose.buttons.AddToCartPlusButton
import com.migrosone.sanalmarket.android.ui.sdk.compose.buttons.CampaignEnrollButton
import com.migrosone.sanalmarket.android.ui.sdk.compose.buttons.CloseButton
import com.migrosone.sanalmarket.android.ui.sdk.compose.buttons.MigrosButton
import com.migrosone.sanalmarket.android.ui.sdk.compose.buttons.MigrosButtonOutlined
import com.migrosone.sanalmarket.android.ui.sdk.compose.cards.InformationCard
import com.migrosone.sanalmarket.android.ui.sdk.compose.checkboxes.MigrosCheckbox
import com.migrosone.sanalmarket.android.ui.sdk.theme.Dimens
import com.migrosone.sanalmarket.android.ui.sdk.compose.R as ComposeR

internal fun sampleComponentPackages(): List<ComponentPackage> = listOf(
    ComponentPackage(
        titleRes = R.string.sample_section_buttons,
        sections = listOf(buttonsSection()),
    ),
    ComponentPackage(
        titleRes = R.string.sample_section_cards,
        sections = listOf(cardsSection()),
    ),
    ComponentPackage(
        titleRes = R.string.sample_section_checkboxes,
        sections = listOf(checkboxesSection()),
    ),
)

private fun buttonsSection(): ComponentSection =
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
                        icon = ComposeR.drawable.sanalmarket_android_ui_sdk_compose_ic_plus,
                    )
                    CampaignEnrollButton(
                        onActionClick = {},
                        buttonText = stringResource(R.string.sample_campaign_enroll_button_text),
                        enrolled = true,
                        icon = ComposeR.drawable.sanalmarket_android_ui_sdk_compose_ic_plus,
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
    )

private fun cardsSection(): ComponentSection =
    ComponentSection(
        titleRes = R.string.sample_section_cards,
        samples = listOf(
            ComponentSample(
                titleRes = R.string.sample_information_card_title,
                descriptionRes = R.string.sample_information_card_description,
            ) {
                InformationCard(
                    modifier = Modifier.fillMaxWidth(),
                    infoText = stringResource(R.string.sample_information_card_text),
                )
            },
        ),
    )

private fun checkboxesSection(): ComponentSection =
    ComponentSection(
        titleRes = R.string.sample_section_checkboxes,
        samples = listOf(
            ComponentSample(
                titleRes = R.string.sample_migros_checkbox_title,
                descriptionRes = R.string.sample_migros_checkbox_description,
            ) {
                var isChecked by rememberSaveable { mutableStateOf(false) }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(Dimens.spacingSmall),
                ) {
                    MigrosCheckbox(
                        isChecked = isChecked,
                        onCheckedChanged = { isChecked = it },
                    )
                    MigrosCheckbox(
                        isChecked = true,
                        onCheckedChanged = {},
                        isEnabled = false,
                    )
                    MigrosCheckbox(
                        isChecked = false,
                        onCheckedChanged = {},
                        isEnabled = false,
                    )
                }
            },
        ),
    )
