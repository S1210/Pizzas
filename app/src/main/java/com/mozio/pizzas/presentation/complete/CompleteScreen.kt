package com.mozio.pizzas.presentation.complete

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mozio.pizzas.R
import com.mozio.pizzas.extensions.collectLifecycle
import com.mozio.pizzas.presentation.common.component.ToolbarScreen

@Composable
fun CompleteScreen(
    navController: NavController,
    viewModel: CompleteViewModel = hiltViewModel(),
    state: CompleteState = viewModel.state.collectLifecycle()
) {
    ToolbarScreen(
        viewModel = viewModel,
        navController = navController,
        title = stringResource(id = R.string.order_successful)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = state.message.asString(), textAlign = TextAlign.Center)
        }
    }
}