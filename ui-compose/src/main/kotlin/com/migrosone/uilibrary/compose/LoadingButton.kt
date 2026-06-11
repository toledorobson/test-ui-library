package com.migrosone.uilibrary.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp

@Composable
fun LoadingButton(
    text: String,
    isLoading: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loadingText: String? = null,
) {
    val state = resolveLoadingButtonState(
        text = text,
        loadingText = loadingText,
        isLoading = isLoading,
        enabled = enabled,
    )

    Button(
        onClick = onClick,
        modifier = modifier.semantics {
            if (isLoading) {
                stateDescription = "Loading"
            }
        },
        enabled = state.isInteractionEnabled,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(18.dp)
                        .semantics { contentDescription = "Loading" },
                    color = MaterialTheme.colorScheme.onPrimary,
                    strokeWidth = 2.dp,
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(text = state.displayText)
        }
    }
}

internal data class LoadingButtonState(
    val displayText: String,
    val isInteractionEnabled: Boolean,
)

internal fun resolveLoadingButtonState(
    text: String,
    loadingText: String?,
    isLoading: Boolean,
    enabled: Boolean,
): LoadingButtonState {
    return LoadingButtonState(
        displayText = if (isLoading) loadingText ?: text else text,
        isInteractionEnabled = enabled && !isLoading,
    )
}
