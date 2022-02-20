package com.elkhoudiry.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elkhoudiry.presentation.screens.checkout.CheckoutEvent
import com.elkhoudiry.presentation.screens.checkout.CheckoutViewModel
import kotlinx.coroutines.launch

actual class CheckoutPlatformViewModel(
    private val viewModel: CheckoutViewModel
) : ViewModel() {

    init {
        viewModelScope.launch { viewModel.listenMenuInteractions() }
    }

    fun getState() = viewModel.state

    fun onEvent(event: CheckoutEvent) {
        viewModelScope.launch { viewModel.onEvent(event) }
    }
}
