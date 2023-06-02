package com.mozio.pizzas.domain.model

import java.math.BigDecimal

data class Pizza(
    val name: String,
    val price: BigDecimal,
    val isSelected: Boolean = false
)
