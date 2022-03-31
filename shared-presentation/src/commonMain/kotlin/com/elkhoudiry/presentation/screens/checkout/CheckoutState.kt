package com.elkhoudiry.presentation.screens.checkout

import com.elkhoudiry.domain.items.models.Item

data class CheckoutState(
    val itemsToCheckout: List<Item>
) {
    fun totalPrice(): Double {
        return itemsToCheckout.sumOf { it.sellingPrice }
    }

    fun items() = itemsToCheckout.groupBy { it.name }

    fun checkoutItemsCount() = itemsToCheckout.size

    fun checkoutItemsTotal() = itemsToCheckout.sumOf { it.sellingPrice }

    companion object {
        val empty = CheckoutState(listOf())
    }
}
