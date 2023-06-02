package com.mozio.pizzas.presentation.pizzas

import com.mozio.pizzas.domain.model.Pizza
import com.mozio.pizzas.domain.use_case.GetAllTastesUseCase
import com.mozio.pizzas.extensions.launch
import com.mozio.pizzas.presentation.common.BaseViewModel
import com.mozio.pizzas.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzasViewModel @Inject constructor(
    private val getAllTastesUseCase: GetAllTastesUseCase
) : BaseViewModel() {

    private val _state = MutableStateFlow(PizzasState())
    val state = _state.asStateFlow()
    private var selectedPizza: Pizza? = null

    init {
        refresh()
    }

    override suspend fun doRefresh() {
        super.doRefresh()
        getAllTastesUseCase.invoke().also {
            _state.update { state ->
                selectedPizza = it.firstOrNull { it.name == selectedPizza?.name }
                state.copy(
                    pizzas = it.map { it.copy(isSelected = it.name == selectedPizza?.name) },
                    hasSelectedPizza = selectedPizza != null,
                    havePizzas = it.isNotEmpty()
                )
            }
        }
    }

    fun changeChecked(pizza: Pizza) {
        selectedPizza = if (pizza.isSelected) null else pizza
        _state.update { state ->
            state.copy(
                pizzas = state.pizzas.map { it.copy(isSelected = it.name == selectedPizza?.name) },
                hasSelectedPizza = selectedPizza != null
            )
        }
    }

    fun complete() = launch {
        selectedPizza?.let {
            navigate(
                route = Screen.CompleteScreen.openRoute(
                    namePizza = it.name,
                    pricePizza = it.price
                )
            )
        }
        selectedPizza = null
    }

}