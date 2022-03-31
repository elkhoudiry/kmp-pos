package com.elkhoudiry.presentation.screens.warehouses

import com.elkhoudiry.domain.items.models.WarehouseItem
import com.elkhoudiry.domain.warehouses.models.Warehouse

data class WarehousesState(
    val warehouses: List<Warehouse>,
    val selectedWarehouse: Int,
) {
    fun items(): List<WarehouseItem> {
        return warehouses[selectedWarehouse].items
    }
}
