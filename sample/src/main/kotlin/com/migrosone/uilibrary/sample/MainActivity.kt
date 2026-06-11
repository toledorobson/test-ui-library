package com.migrosone.uilibrary.sample

import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SampleApp() {
    val packages = remember { sampleComponentPackages() }
    var selectedPackageIndex by rememberSaveable { mutableStateOf<Int?>(null) }
    val selectedPackage = selectedPackageIndex?.let { packages.getOrNull(it) }
    val navigateUp = { selectedPackageIndex = null }

    BackHandler(enabled = selectedPackage != null, onBack = navigateUp)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(
                            selectedPackage?.titleRes ?: R.string.sample_app_name,
                        ),
                    )
                },
                navigationIcon = {
                    if (selectedPackage != null) {
                        IconButton(onClick = navigateUp) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.sample_back_content_description),
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
            MigrosTheme(companyType = MigrosCompanyType.SANALMARKET) {
                if (selectedPackage == null) {
                    ComponentPackageListScreen(
                        packages = packages,
                        onPackageClick = { selectedPackageIndex = it },
                    )
                } else {
                    ComponentCatalogScreen(sections = selectedPackage.sections)
                }
            }
        }
    }
}
