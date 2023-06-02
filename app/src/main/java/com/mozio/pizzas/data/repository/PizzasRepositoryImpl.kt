package com.mozio.pizzas.data.repository

import com.mozio.pizzas.controller.AppController
import com.mozio.pizzas.data.remote.api.ApiManager
import com.mozio.pizzas.domain.model.Pizza
import com.mozio.pizzas.domain.repository.PizzasRepository
import com.mozio.pizzas.extensions.withIO
import com.mozio.pizzas.util.mapper.toPizza
import javax.inject.Inject

class PizzasRepositoryImpl @Inject constructor(
    private val apiManager: ApiManager,
    private val appController: AppController
) : PizzasRepository {

    override suspend fun getPizzas(): List<Pizza> = withIO {
        apiManager.getPizzas().run {
            if (isSuccessful) {
                body()?.map { it.toPizza() } ?: emptyList()
            } else {
                appController.sendError(Exception(errorBody()?.string() ?: ""))
                emptyList()
            }
        }
    }

}