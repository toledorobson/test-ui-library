package com.andrikod.testuilibrary.view

import android.content.Context
import android.view.LayoutInflater
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.andrikod.testuilibrary.view.test.R as TestR
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoadingButtonViewTest {
    @Test
    fun inflatesXmlAttributes() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val view = LayoutInflater.from(context).inflate(
            TestR.layout.tul_loading_button_view_test,
            null,
            false,
        ) as LoadingButtonView

        assertEquals("Send", view.text.toString())
        assertEquals("Sending", view.loadingText.toString())
        assertTrue(view.isLoading)
    }
}
