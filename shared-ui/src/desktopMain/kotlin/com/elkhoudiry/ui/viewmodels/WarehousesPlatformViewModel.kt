package com.elkhoudiry.ui.viewmodels

import com.elkhoudiry.presentation.screens.checkout.CheckoutEvent
import com.elkhoudiry.presentation.screens.warehouses.WarehousesEvent
import com.elkhoudiry.presentation.screens.warehouses.WarehousesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

actual class WarehousesPlatformViewModel(
    private val viewModel: WarehousesViewModel
) {

    private val scope = CoroutineScope(Dispatchers.Default)

    fun getState() = viewModel.state

    fun onEvent(event: WarehousesEvent) {
        scope.launch { viewModel.onEvent(event) }
    }
}