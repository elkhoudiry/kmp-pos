package com.elkhoudiry.presentation.screens.menu

import com.elkhoudiry.domain.items.models.Item
import com.elkhoudiry.domain.warehouses.models.Warehouse

sealed class MenuEvent {
    class OnMenuItemClick(val item: Item) : MenuEvent()

    class OnWarehouseFilter(val warehouse: Warehouse) : MenuEvent()
}
