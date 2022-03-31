package com.elkhoudiry.presentation.screens.menu

import com.elkhoudiry.domain.items.models.Item
import com.elkhoudiry.domain.items.models.WarehouseItem
import com.elkhoudiry.domain.warehouses.models.Warehouse

data class MenuState(
    val items: List<Item>,
    val warehouses: List<Warehouse>,
    val selectedWarehouse: Int = 0
) {
    fun getSelectedWarehouseName(): String {
        return warehouses[selectedWarehouse].name
    }

    fun getFilteredAvailableItems(): List<WarehouseItem> =
        warehouses[selectedWarehouse].items.filter { it.isAvailable }

    fun getFilteredNotAvailableItems(): List<WarehouseItem> =
        warehouses[selectedWarehouse].items.filter { !it.isAvailable }
}
