package com.elkhoudiry.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elkhoudiry.presentation.screens.checkout.CheckoutEvent
import com.elkhoudiry.presentation.screens.warehouses.WarehousesEvent
import com.elkhoudiry.presentation.screens.warehouses.WarehousesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

actual class WarehousesPlatformViewModel(
    private val viewModel: WarehousesViewModel
): ViewModel() {

    fun getState() = viewModel.state

    fun onEvent(event: WarehousesEvent) {
        viewModelScope.launch { viewModel.onEvent(event) }
    }
}