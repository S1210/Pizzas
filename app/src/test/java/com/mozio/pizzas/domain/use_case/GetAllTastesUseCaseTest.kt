package com.mozio.pizzas.domain.use_case

import com.mozio.pizzas.data.repository.PizzasRepositoryImplTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.math.BigDecimal

@OptIn(ExperimentalCoroutinesApi::class)
internal class GetAllTastesUseCaseTest {

    private val getAllTastesUseCase = GetAllTastesUseCase(PizzasRepositoryImplTest())

    @Test
    fun getAllTastes() = runTest {
        val pizzas = getAllTastesUseCase.getAllTastes()
        assertEquals(6, pizzas.size)
        assertEquals("Margherita", pizzas[0].name)
        assertEquals(BigDecimal(10), pizzas[0].price)
        assertEquals("Pepperoni", pizzas[1].name)
        assertEquals(BigDecimal(12), pizzas[1].price)
        assertEquals("Hawaiian", pizzas[2].name)
        assertEquals(BigDecimal(13), pizzas[2].price)
        assertEquals("Margherita / Pepperoni", pizzas[3].name)
        assertEquals(BigDecimal(11), pizzas[3].price)
        assertEquals("Margherita / Hawaiian", pizzas[4].name)
        assertEquals(BigDecimal(11.5), pizzas[4].price)
        assertEquals("Pepperoni / Hawaiian", pizzas[5].name)
        assertEquals(BigDecimal(12.5), pizzas[5].price)
    }
}