package com.mozio.pizzas.util

import com.mozio.pizzas.presentation.complete.CompleteViewModel
import java.math.BigDecimal

sealed class Screen(val route: String) {

    object PizzasScreen : Screen("pizzas_screen")

    object CompleteScreen : Screen("complete_screen") {

        fun openRoute(namePizza: String, pricePizza: BigDecimal) = route +
                "?${CompleteViewModel.NAME_PIZZA}=$namePizza" +
                "&${CompleteViewModel.PRICE_PIZZA}=$pricePizza"

    }

}