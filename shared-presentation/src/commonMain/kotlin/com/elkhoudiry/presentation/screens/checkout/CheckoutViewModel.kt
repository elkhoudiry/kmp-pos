package com.elkhoudiry.presentation.screens.checkout

import com.elkhoudiry.domain.items.models.ListingItem
import com.elkhoudiry.domain.repositories.menu.BaseMenuInteractions
import com.elkhoudiry.domain.utils.added
import com.elkhoudiry.domain.utils.removed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CheckoutViewModel(
    private val menuInteractions: BaseMenuInteractions
) {
    private val _state = MutableStateFlow(CheckoutState(listOf()))
    val state: StateFlow<CheckoutState> = _state

    suspend fun listenMenuInteractions() {
        menuInteractions.listen().collect {
            _state.value = _state.value.copy(
                itemsToCheckout = _state.value.itemsToCheckout.added(it)
            )
        }
    }

    suspend fun onEvent(event: CheckoutEvent) {
        when (event) {
            is CheckoutEvent.ItemClick -> {
                itemClick(event.item)
            }
            CheckoutEvent.ClearItems -> {
                clearItems()
            }
        }
    }

    private fun itemClick(item: ListingItem) {
        val index = _state.value.itemsToCheckout.lastIndexOf(item)
        _state.value = _state.value.copy(
            itemsToCheckout = _state.value.itemsToCheckout.removed(index)
        )
    }

    private fun clearItems() {
        _state.value = _state.value.copy(itemsToCheckout = listOf())
    }
}
