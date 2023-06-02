package com.mozio.pizzas.util.mapper

import com.mozio.pizzas.data.remote.dto.PizzaDto
import com.mozio.pizzas.domain.model.Pizza
import java.math.BigDecimal

fun PizzaDto.toPizza(): Pizza {
    return Pizza(name = name, price = BigDecimal(price))
}