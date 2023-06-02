package com.mozio.pizzas.presentation

import com.mozio.pizzas.controller.AppController
import com.mozio.pizzas.extensions.launchWithHandle
import com.mozio.pizzas.presentation.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    appController: AppController
) : BaseViewModel() {

    init {
        appController.errorHandler.onEach {
            errorEvents(it.throwable, it.isShowError)
        }.launchWithHandle(this)
        appController.appMessage.onEach {
            showErrorDialog(title = it.title, message = it.message)
        }.launchWithHandle(this)
    }

}