package com.elkhoudiry.presentation.screens.checkout

import com.elkhoudiry.domain.items.models.ListingItem

sealed class CheckoutEvent {
    object ClearItems : CheckoutEvent()

    class ItemClick(val item: ListingItem) : CheckoutEvent()
}
