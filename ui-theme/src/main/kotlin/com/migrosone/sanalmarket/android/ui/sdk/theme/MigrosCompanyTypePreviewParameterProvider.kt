package com.migrosone.sanalmarket.android.ui.sdk.theme

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class MigrosCompanyTypePreviewParameterProvider : PreviewParameterProvider<MigrosCompanyType> {
    override val values: Sequence<MigrosCompanyType> = MigrosCompanyType.entries.asSequence()

    override fun getDisplayName(index: Int): String? = MigrosCompanyType.entries.getOrNull(index)?.name
}
