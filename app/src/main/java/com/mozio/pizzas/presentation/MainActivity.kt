package com.mozio.pizzas.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mozio.pizzas.presentation.SharedViewModel
import com.mozio.pizzas.presentation.common.component.ViewModelScreen
import com.mozio.pizzas.presentation.complete.CompleteScreen
import com.mozio.pizzas.presentation.complete.CompleteViewModel
import com.mozio.pizzas.presentation.pizzas.PizzasScreen
import com.mozio.pizzas.ui.theme.PizzasTheme
import com.mozio.pizzas.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzasTheme {
                val viewModel = hiltViewModel<SharedViewModel>()
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    ViewModelScreen(viewModel = viewModel, navController = navController) {
                        NavHost(
                            navController = navController,
                            startDestination = Screen.PizzasScreen.route
                        ) {
                            composable(route = Screen.PizzasScreen.route) {
                                PizzasScreen(navController = navController)
                            }

                            composable(
                                route = Screen.CompleteScreen.route +
                                        "?${CompleteViewModel.NAME_PIZZA}={${CompleteViewModel.NAME_PIZZA}}" +
                                        "&${CompleteViewModel.PRICE_PIZZA}={${CompleteViewModel.PRICE_PIZZA}}",
                                arguments = listOf(
                                    navArgument(name = CompleteViewModel.NAME_PIZZA) {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    },
                                    navArgument(name = CompleteViewModel.PRICE_PIZZA) {
                                        type = NavType.StringType
                                        defaultValue = ""
                                    }
                                )
                            ) {
                                CompleteScreen(navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}