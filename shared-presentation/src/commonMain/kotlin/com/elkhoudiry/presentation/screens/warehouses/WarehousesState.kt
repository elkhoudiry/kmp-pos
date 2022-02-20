package com.elkhoudiry.presentation.screens.warehouses

import com.elkhoudiry.domain.items.models.ListingItem
import com.elkhoudiry.domain.warehouses.models.Warehouse

data class WarehousesState(
    val warehouses: List<Warehouse>,
    val selectedWarehouse: Int,
) {
    fun items(): List<ListingItem> {
        return warehouses[selectedWarehouse].items
    }
}
