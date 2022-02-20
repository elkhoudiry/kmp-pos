package com.elkhoudiry.presentation.screens.menu

import com.elkhoudiry.domain.items.models.ListingItem
import com.elkhoudiry.domain.repositories.menu.BaseMenuInteractions
import com.elkhoudiry.domain.warehouses.models.Warehouse
import com.elkhoudiry.presentation.screens.warehouses.fakeWarehouses
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MenuViewModel(
    private val menuInteractions: BaseMenuInteractions,
) {
    private val _state = MutableStateFlow(
        MenuState(
            fakeItems,
            fakeWarehouses
        )
    )
    val state: StateFlow<MenuState> = _state

    suspend fun onEvent(event: MenuEvent) {
        when (event) {
            is MenuEvent.OnMenuItemClick -> {
                onMenuItemClick(event.item)
            }

            is MenuEvent.OnWarehouseFilter -> {
                onWarehouseFilter(event.warehouse)
            }
        }
    }

    private fun onWarehouseFilter(warehouse: Warehouse) {
        _state.value = _state.value.copy(
            selectedWarehouse = _state.value.warehouses.indexOf(warehouse)
        )
    }

    private suspend fun onMenuItemClick(item: ListingItem) {
        menuInteractions.itemClick(item)
    }
}

val fakeItems: List<ListingItem> = listOf(
    ListingItem(
        1,
        1001,
        "Burger",
        15.0,
        10.0,
        3.0
    ),
    ListingItem(
        2,
        1002,
        "Pizza",
        25.0,
        20.0,
        3.0
    ),
    ListingItem(
        3,
        1003,
        "Koshary",
        10.0,
        7.0,
        3.0
    ),
    ListingItem(
        4,
        1004,
        "Chicken",
        50.0,
        40.0,
        3.0
    ),
    ListingItem(
        5,
        1005,
        "Crepe",
        30.0,
        25.0,
        3.0
    )
)
