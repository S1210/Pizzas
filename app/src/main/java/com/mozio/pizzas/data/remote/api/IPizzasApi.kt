package com.mozio.pizzas.data.remote.api

import com.mozio.pizzas.data.remote.dto.PizzaDto
import retrofit2.Response
import retrofit2.http.GET

interface IPizzasApi {

    @GET("mobile/tests/pizzas.json")
    suspend fun getPizzas(): Response<List<PizzaDto>>

}