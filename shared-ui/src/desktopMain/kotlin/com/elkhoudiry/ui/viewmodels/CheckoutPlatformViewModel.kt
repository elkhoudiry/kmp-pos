package com.elkhoudiry.ui.viewmodels

import com.elkhoudiry.presentation.screens.checkout.CheckoutEvent
import com.elkhoudiry.presentation.screens.checkout.CheckoutViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

actual class CheckoutPlatformViewModel(
    private val viewModel: CheckoutViewModel
) {

    private val scope = CoroutineScope(Dispatchers.Default)

    init {
        scope.launch { viewModel.listenMenuInteractions() }
    }

    fun getState() = viewModel.state

    fun onEvent(event: CheckoutEvent) {
        scope.launch { viewModel.onEvent(event) }
    }
}
