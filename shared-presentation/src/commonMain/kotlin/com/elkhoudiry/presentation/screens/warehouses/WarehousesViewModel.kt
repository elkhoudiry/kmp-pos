package com.elkhoudiry.presentation.screens.warehouses

import com.elkhoudiry.domain.warehouses.models.Warehouse
import com.elkhoudiry.presentation.screens.menu.fakeItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WarehousesViewModel {

    private val _state = MutableStateFlow(
        WarehousesState(
            warehouses = fakeWarehouses, selectedWarehouse = 0
        )
    )
    val state: StateFlow<WarehousesState> = _state

    fun onEvent(event: WarehousesEvent) {
        when (event) {
            is WarehousesEvent.OnWarehouseClick -> {
                onWarehouseClick(event.id)
            }
        }
    }

    private fun onWarehouseClick(id: Int) {
        _state.value = _state.value.copy(selectedWarehouse = id)
    }
}

val fakeWarehouses = listOf(
    Warehouse(0, "Main", fakeItems),
    Warehouse(1, "South", listOf(fakeItems[0], fakeItems[3].copy(isAvailable = false))),
    Warehouse(2, "East", listOf(fakeItems[0], fakeItems[1], fakeItems[2])),
)
