package com.migrosone.uilibrary.sample

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.migrosone.uilibrary.compose.buttons.MigrosButton
import com.migrosone.uilibrary.compose.buttons.MigrosButtonOutlined

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
        ),
    ),
)
