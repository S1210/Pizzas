package com.mozio.pizzas.domain.repository

import com.mozio.pizzas.domain.model.Pizza

interface PizzasRepository {

    suspend fun getPizzas(): List<Pizza>

}