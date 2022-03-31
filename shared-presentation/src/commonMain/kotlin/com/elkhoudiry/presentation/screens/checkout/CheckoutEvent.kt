package com.elkhoudiry.presentation.screens.checkout

import com.elkhoudiry.domain.items.models.Item

sealed class CheckoutEvent {
    object ClearItems : CheckoutEvent()

    class ItemClick(val item: Item) : CheckoutEvent()
}
