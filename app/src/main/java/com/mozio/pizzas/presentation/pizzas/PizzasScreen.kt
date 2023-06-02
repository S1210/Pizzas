package com.mozio.pizzas.presentation.pizzas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mozio.pizzas.R
import com.mozio.pizzas.extensions.collectLifecycle
import com.mozio.pizzas.extensions.navigateIfPossible
import com.mozio.pizzas.presentation.common.component.SwipeRefresh
import com.mozio.pizzas.presentation.common.component.ToolbarScreen
import com.mozio.pizzas.presentation.pizzas.component.PizzaItem
import com.mozio.pizzas.util.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PizzasScreen(
    navController: NavController,
    viewModel: PizzasViewModel = hiltViewModel(),
    state: PizzasState = viewModel.state.collectLifecycle(),
    isRefreshing: Boolean = viewModel.isRefreshing.collectLifecycle()
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = viewModel::refresh
    )
    ToolbarScreen(
        viewModel = viewModel,
        navController = navController,
        isShowIcon = false,
        floatingActionButton = {
            if (state.hasSelectedPizza) {
                FloatingActionButton(onClick = viewModel::complete) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = null)
                }
            }
        }
    ) {
        SwipeRefresh(state = pullRefreshState, isRefreshing = isRefreshing) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        items = state.pizzas,
                        key = { it.name }
                    ) {
                        PizzaItem(
                            modifier = Modifier.fillMaxWidth(),
                            pizza = it,
                            onCheckedChange = viewModel::changeChecked
                        )
                    }
                }
                if (!state.havePizzas && !isRefreshing) {
                    Text(text = stringResource(id = R.string.no_pizzas_message))
                }
            }
        }
    }
}