package com.mozio.pizzas.domain.use_case

import com.mozio.pizzas.domain.model.Pizza
import com.mozio.pizzas.domain.repository.PizzasRepository
import com.mozio.pizzas.extensions.withIO
import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllTastesUseCase @Inject constructor(
    private val pizzasRepository: PizzasRepository
) {

    suspend operator fun invoke(): List<Pizza> = withIO {
        pizzasRepository.getPizzas().run {
            val pizzas = toMutableList()
            val divider = BigDecimal(2)
            for (i in 0 until size - 1) {
                for (j in i + 1 until size) {
                    pizzas.add(
                        Pizza(
                            name = "${get(i).name} / ${get(j).name}",
                            price = get(i).price.plus(get(j).price).divide(divider)
                        )
                    )
                }
            }
            pizzas
        }
    }

}