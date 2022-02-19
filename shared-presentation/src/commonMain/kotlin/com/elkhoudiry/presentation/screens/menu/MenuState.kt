package com.elkhoudiry.presentation.screens.menu

import com.elkhoudiry.domain.items.models.ListingItem
import com.elkhoudiry.domain.warehouses.models.Warehouse

data class MenuState(
    val items: List<ListingItem>, val warehouses: List<Warehouse>, val selectedWarehouse: Int = 0
) {
    fun getSelectedWarehouseName(): String {
        return warehouses[selectedWarehouse].name
    }

    fun getFilteredAvailableItems(): List<ListingItem> = warehouses[selectedWarehouse].items.filter { it.isAvailable }

    fun getFilteredNotAvailableItems(): List<ListingItem> = warehouses[selectedWarehouse].items.filter { !it.isAvailable }
}