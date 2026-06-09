package com.andrikod.testuilibrary.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ProgressBar

class LoadingButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {
    private val button = Button(context).apply {
        id = View.generateViewId()
        setAllCaps(false)
    }
    private val progressBar = ProgressBar(context).apply {
        id = View.generateViewId()
        isIndeterminate = true
        importantForAccessibility = IMPORTANT_FOR_ACCESSIBILITY_NO
        visibility = GONE
    }

    var text: CharSequence = DEFAULT_TEXT
        set(value) {
            field = value
            render()
        }

    var loadingText: CharSequence? = null
        set(value) {
            field = value
            render()
        }

    var isLoading: Boolean = false
        set(value) {
            field = value
            render()
        }

    init {
        clipToPadding = false

        addView(
            button,
            LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            ),
        )
        addView(
            progressBar,
            LayoutParams(dp(18), dp(18), Gravity.START or Gravity.CENTER_VERTICAL).apply {
                marginStart = dp(20)
            },
        )

        readAttributes(context, attrs, defStyleAttr)
        render()
    }

    override fun setOnClickListener(listener: OnClickListener?) {
        button.setOnClickListener(listener)
        isClickable = listener != null
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        render()
    }

    private fun readAttributes(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        if (attrs == null) return

        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.TulLoadingButtonView,
            defStyleAttr,
            0,
        )
        try {
            text = typedArray.getText(
                R.styleable.TulLoadingButtonView_tul_loadingButtonText,
            ) ?: DEFAULT_TEXT
            loadingText = typedArray.getText(
                R.styleable.TulLoadingButtonView_tul_loadingButtonLoadingText,
            )
            isLoading = typedArray.getBoolean(
                R.styleable.TulLoadingButtonView_tul_loadingButtonIsLoading,
                false,
            )
        } finally {
            typedArray.recycle()
        }
    }

    private fun render() {
        val state = LoadingButtonStateResolver.resolve(
            text = text,
            loadingText = loadingText,
            isLoading = isLoading,
            enabled = isEnabled,
        )

        button.text = state.displayText
        button.isEnabled = state.isInteractionEnabled
        progressBar.visibility = if (isLoading) VISIBLE else GONE
        contentDescription = state.displayText
    }

    private fun dp(value: Int): Int {
        return (value * resources.displayMetrics.density).toInt()
    }

    private companion object {
        const val DEFAULT_TEXT = "Submit"
    }
}

internal data class ViewLoadingButtonState(
    val displayText: CharSequence,
    val isInteractionEnabled: Boolean,
)

internal object LoadingButtonStateResolver {
    fun resolve(
        text: CharSequence,
        loadingText: CharSequence?,
        isLoading: Boolean,
        enabled: Boolean,
    ): ViewLoadingButtonState {
        return ViewLoadingButtonState(
            displayText = if (isLoading) loadingText ?: text else text,
            isInteractionEnabled = enabled && !isLoading,
        )
    }
}
