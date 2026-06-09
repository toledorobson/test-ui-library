package com.andrikod.testuilibrary.sample

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.andrikod.testuilibrary.compose.LoadingButton
import com.andrikod.testuilibrary.view.LoadingButtonView
import android.widget.FrameLayout
import kotlinx.coroutines.delay

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SampleApp() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf(
        stringResource(R.string.tul_sample_compose_tab),
        stringResource(R.string.tul_sample_view_tab),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.tul_sample_app_name)) },
            )
        },
    ) { contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
        ) {
            Column {
                PrimaryTabRow(selectedTabIndex = selectedTab) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = { Text(text = title) },
                        )
                    }
                }

                when (selectedTab) {
                    0 -> ComposeLoadingButtonSample()
                    else -> XmlLoadingButtonSample()
                }
            }
        }
    }
}

@Composable
private fun ComposeLoadingButtonSample() {
    var isLoading by remember { mutableStateOf(false) }
    if (isLoading) {
        LaunchedEffect(Unit) {
            delay(1_200)
            isLoading = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(R.string.tul_sample_compose_title),
            style = MaterialTheme.typography.headlineSmall,
        )
        Text(
            text = stringResource(R.string.tul_sample_body),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.height(16.dp))
        LoadingButton(
            text = stringResource(R.string.tul_sample_submit),
            loadingText = stringResource(R.string.tul_sample_loading),
            isLoading = isLoading,
            onClick = { isLoading = true },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
private fun XmlLoadingButtonSample() {
    var isLoading by remember { mutableStateOf(false) }
    if (isLoading) {
        LaunchedEffect(Unit) {
            delay(1_200)
            isLoading = false
        }
    }

    AndroidView(
        modifier = Modifier.fillMaxWidth(),
        factory = { context ->
            val parent = FrameLayout(context)
            LayoutInflater.from(context).inflate(
                R.layout.tul_sample_view_loading_button,
                parent,
                false,
            )
        },
        update = { root ->
            root.findViewById<LoadingButtonView>(
                R.id.tul_sample_xml_loading_button,
            ).apply {
                this.isLoading = isLoading
                setOnClickListener { isLoading = true }
            }
        },
    )
}
