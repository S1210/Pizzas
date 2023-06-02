package com.mozio.pizzas.presentation.complete

import androidx.lifecycle.SavedStateHandle
import com.mozio.pizzas.R
import com.mozio.pizzas.presentation.common.BaseViewModel
import com.mozio.pizzas.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CompleteViewModel @Inject constructor(
    stateHandle: SavedStateHandle
) : BaseViewModel() {

    companion object {
        const val NAME_PIZZA = "name_pizza"
        const val PRICE_PIZZA = "price_pizza"
    }

    private val _state = MutableStateFlow(CompleteState())
    val state = _state.asStateFlow()

    init {
        _state.update { state ->
            state.copy(
                message = UiText.StringResource(
                    R.string.complete_message,
                    listOf(
                        stateHandle.get<String>(NAME_PIZZA) ?: "",
                        stateHandle.get<String>(PRICE_PIZZA) ?: ""
                    )
                )
            )
        }
    }

}