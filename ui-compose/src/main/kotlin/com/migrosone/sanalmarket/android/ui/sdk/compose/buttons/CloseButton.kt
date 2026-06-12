package com.migrosone.sanalmarket.android.ui.sdk.compose.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.migrosone.sanalmarket.android.ui.sdk.compose.R
import com.migrosone.sanalmarket.android.ui.sdk.theme.BasicColors
import com.migrosone.sanalmarket.android.ui.sdk.theme.Dimens
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosCompanyType
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosTheme

@Composable
fun CloseButton(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = BasicColors.White,
    iconTint: Color = BasicColors.Basic700,
    closeContentDescription: String? = null,
    testTag: String? = null
) {
    val resolvedContentDescription =
        closeContentDescription ?: stringResource(R.string.sanalmarket_android_ui_sdk_compose_button_close)

    val closeButtonModifier = modifier
        .size(Dimens.dp_36)
        .then(
            if (testTag != null) {
                Modifier.testTag(testTag)
            } else {
                Modifier
            }
        )
        .semantics {
            contentDescription = resolvedContentDescription
        }
        .clickable(
            role = Role.Button,
            onClick = onDismiss,
        )

    Surface(
        modifier = closeButtonModifier,
        shape = CircleShape,
        color = backgroundColor
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(Dimens.dp_20)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun CloseButtonPreview() {
    MigrosTheme(companyType = MigrosCompanyType.SANALMARKET) {
        CloseButton(
            onDismiss = {}
        )
    }
}
