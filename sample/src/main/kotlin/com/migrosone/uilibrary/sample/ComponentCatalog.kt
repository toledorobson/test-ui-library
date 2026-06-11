package com.migrosone.uilibrary.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

internal data class ComponentSection(
    val titleRes: Int,
    val samples: List<ComponentSample>,
)

internal data class ComponentSample(
    val titleRes: Int,
    val descriptionRes: Int? = null,
    val content: @Composable () -> Unit,
)

@Composable
internal fun ComponentCatalogScreen(
    sections: List<ComponentSection>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        sections.forEach { section ->
            item(key = section.titleRes) {
                ComponentSectionContent(section = section)
            }
        }
    }
}

@Composable
private fun ComponentSectionContent(section: ComponentSection) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = stringResource(section.titleRes),
            style = MaterialTheme.typography.headlineSmall,
        )
        section.samples.forEach { sample ->
            ComponentSampleCard(sample = sample)
        }
    }
}

@Composable
private fun ComponentSampleCard(sample: ComponentSample) {
    OutlinedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = stringResource(sample.titleRes),
                    style = MaterialTheme.typography.titleMedium,
                )
                sample.descriptionRes?.let { descriptionRes ->
                    Text(
                        text = stringResource(descriptionRes),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
            sample.content()
        }
    }
}
