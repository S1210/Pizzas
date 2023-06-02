package com.mozio.pizzas.presentation.common.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.mozio.pizzas.R
import com.mozio.pizzas.presentation.common.BaseViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun <V : BaseViewModel> ToolbarScreen(
    modifier: Modifier = Modifier,
    viewModel: V,
    navController: NavController,
    parentNavController: NavController? = null,
    title: String = stringResource(id = R.string.app_name),
    titleExtraContent: @Composable @UiComposable (() -> Unit)? = null,
    isShowIcon: Boolean = true,
    icon: ImageVector = Icons.Filled.ArrowBack,
    iconClick: () -> Unit = { navController.popBackStack() },
    actions: @Composable RowScope.() -> Unit = {},
    onQueryChange: (query: String) -> Unit = {},
    onStateChange: (isOpen: Boolean) -> Unit = {},
    onClearClick: () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    isFloatingActionButtonDocked: Boolean = false,
    backgroundColor: Color = MaterialTheme.colors.background,
    toolbarBackgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    content: @Composable @UiComposable (PaddingValues) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    ViewModelScreen(
        viewModel = viewModel,
        navController = navController,
        parentNavController = parentNavController,
    ) {
        Scaffold(
            modifier = modifier,
            topBar = {
                Toolbar(
                    title = title,
                    titleExtraContent = titleExtraContent,
                    isShowIcon = isShowIcon,
                    icon = icon,
                    onBackPressed = {
                        keyboardController?.hide()
                        iconClick()
                    },
                    actions = actions,
                    backgroundColor = toolbarBackgroundColor
                )
            },
            bottomBar = bottomBar,
            floatingActionButton = floatingActionButton,
            floatingActionButtonPosition = floatingActionButtonPosition,
            isFloatingActionButtonDocked = isFloatingActionButtonDocked,
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            content = content
        )
    }
}
