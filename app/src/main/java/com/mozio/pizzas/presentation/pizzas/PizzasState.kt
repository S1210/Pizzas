package com.mozio.pizzas.presentation.pizzas

import androidx.compose.runtime.Stable
import com.mozio.pizzas.domain.model.Pizza

data class PizzasState(
    @Stable
    val pizzas: List<Pizza> = emptyList(),
    val havePizzas: Boolean = false,
    val hasSelectedPizza: Boolean = false
)
