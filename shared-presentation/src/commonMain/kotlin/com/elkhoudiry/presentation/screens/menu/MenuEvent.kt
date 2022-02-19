package com.elkhoudiry.presentation.screens.menu

import com.elkhoudiry.domain.items.models.ListingItem
import com.elkhoudiry.domain.warehouses.models.Warehouse

sealed class MenuEvent {
    class OnMenuItemClick(val item: ListingItem) : MenuEvent()

    class OnWarehouseFilter(val warehouse: Warehouse): MenuEvent()
}