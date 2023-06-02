package com.mozio.pizzas.di

import com.mozio.pizzas.data.repository.PizzasRepositoryImpl
import com.mozio.pizzas.domain.repository.PizzasRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPizzasRepository(
        pizzasRepositoryImpl: PizzasRepositoryImpl
    ): PizzasRepository

}