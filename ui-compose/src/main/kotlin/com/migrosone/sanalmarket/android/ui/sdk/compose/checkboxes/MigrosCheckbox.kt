package com.migrosone.sanalmarket.android.ui.sdk.compose.checkboxes


import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.migrosone.sanalmarket.android.ui.sdk.theme.BorderColors
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosCompanyType
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosCompanyTypePreviewParameterProvider
import com.migrosone.sanalmarket.android.ui.sdk.theme.MigrosTheme

@Composable
fun MigrosCheckbox(
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChanged: (Boolean) -> Unit,
    isEnabled: Boolean = true,
) {
    Checkbox(
        modifier = modifier,
        checked = isChecked,
        onCheckedChange = onCheckedChanged,
        enabled = isEnabled,
        colors = CheckboxDefaults.colors(
            checkedColor = MigrosTheme.colors.colorSecondary,
            uncheckedColor = BorderColors.borderInputDefault,
            checkmarkColor = Color.White,
        )
    )
}


@Preview(showBackground = true)
@Composable
private fun MigrosCheckboxTruePreview(
    @PreviewParameter(MigrosCompanyTypePreviewParameterProvider::class) companyType: MigrosCompanyType
) {
    MigrosTheme(companyType = companyType) {
        MigrosCheckbox(
            isChecked = true,
            modifier = Modifier,
            onCheckedChanged = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MigrosCheckboxFalsePreview(
    @PreviewParameter(MigrosCompanyTypePreviewParameterProvider::class) companyType: MigrosCompanyType
) {
    MigrosTheme(companyType = companyType) {
        MigrosCheckbox(
            isChecked = false,
            onCheckedChanged = {}
        )
    }
}