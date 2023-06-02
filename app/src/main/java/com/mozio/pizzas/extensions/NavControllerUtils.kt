package com.mozio.pizzas.extensions

import androidx.navigation.NavController

fun NavController.navigateIfPossible(route: String) {
    tryCatch { navigate(route) }
}
