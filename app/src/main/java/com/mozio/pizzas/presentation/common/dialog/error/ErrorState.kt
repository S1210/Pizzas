package com.mozio.pizzas.presentation.common.dialog.error

import com.mozio.pizzas.util.UiText

data class ErrorState(
    val isShow: Boolean = false,
    val title: UiText = UiText.DynamicString(""),
    val message: UiText = UiText.DynamicString("")
)
