package com.mozio.pizzas.presentation.common.dialog.progress_bar

import com.mozio.pizzas.util.UiText

data class ProgressDialogState(
    val isShow: Boolean = false,
    val text: UiText = UiText.DynamicString(""),
    val tag: String = ""
) {

    companion object {
        const val LOADING_TAG = "Loading"
        const val AUTHENTICATING_TAG = "Authenticating"
    }

}
