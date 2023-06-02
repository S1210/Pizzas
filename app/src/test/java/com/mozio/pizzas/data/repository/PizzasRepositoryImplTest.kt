package com.mozio.pizzas.data.repository

import com.mozio.pizzas.domain.model.Pizza
import com.mozio.pizzas.domain.repository.PizzasRepository
import java.math.BigDecimal


internal class PizzasRepositoryImplTest : PizzasRepository {

    override suspend fun getPizzas(): List<Pizza> {
        return listOf(
            Pizza("Margherita", BigDecimal(10)),
            Pizza("Pepperoni", BigDecimal(12)),
            Pizza("Hawaiian", BigDecimal(13))
        )
    }

}