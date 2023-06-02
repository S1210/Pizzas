package com.mozio.pizzas.data.remote.api

import com.mozio.pizzas.data.remote.dto.PizzaDto
import com.mozio.pizzas.extensions.withIO
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiManager @Inject constructor(
    private val iPizzasApi: IPizzasApi
) {

    suspend fun getPizzas(): Response<List<PizzaDto>> = withIO {
        iPizzasApi.getPizzas()
    }

}