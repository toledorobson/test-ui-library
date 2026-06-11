package com.migrosone.uilibrary.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.migrosone.uilibrary.compose.MigrosButton
import com.migrosone.uilibrary.theme.MigrosCompanyType
import com.migrosone.uilibrary.theme.MigrosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                SampleApp()
            }
        }
    }
}

private val sampleComponents = listOf(
    SampleComponent(
        id = "migros_button",
        titleRes = R.string.sample_component_migros_button,
        content = { MigrosButtonSample() },
    ),
)

private data class SampleComponent(
    val id: String,
    val titleRes: Int,
    val content: @Composable () -> Unit,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SampleApp() {
    var selectedComponentId by rememberSaveable { mutableStateOf<String?>(null) }
    val selectedComponent = sampleComponents.firstOrNull { component ->
        component.id == selectedComponentId
    }

    BackHandler(enabled = selectedComponent != null) {
        selectedComponentId = null
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.sample_app_name)) },
                navigationIcon = {
                    if (selectedComponent != null) {
                        IconButton(onClick = { selectedComponentId = null }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(
                                    R.string.sample_back_content_description,
                                ),
                            )
                        }
                    }
                },
            )
        },
    ) { contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
        ) {
            if (selectedComponent == null) {
                SampleComponentList(
                    components = sampleComponents,
                    onComponentClick = { component ->
                        selectedComponentId = component.id
                    },
                )
            } else {
                selectedComponent.content()
            }
        }
    }
}

@Composable
private fun SampleComponentList(
    components: List<SampleComponent>,
    onComponentClick: (SampleComponent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp),
    ) {
        items(
            items = components,
            key = { component -> component.id },
        ) { component ->
            ListItem(
                headlineContent = {
                    Text(text = stringResource(component.titleRes))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onComponentClick(component) },
            )
            HorizontalDivider()
        }
    }
}

@Composable
private fun MigrosButtonSample() {
    MigrosTheme(companyType = MigrosCompanyType.SANALMARKET) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            MigrosButton(
                buttonText = stringResource(R.string.sample_component_migros_button),
                buttonOnClickAction = {},
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
