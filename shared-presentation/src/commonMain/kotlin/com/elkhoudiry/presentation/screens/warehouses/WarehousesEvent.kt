package com.elkhoudiry.presentation.screens.warehouses

sealed class WarehousesEvent {

    class OnWarehouseClick(val id: Int) : WarehousesEvent()
}
