package com.elkhoudiry.domain.items.models

data class ListingItem(
    val id: Int,
    val code: Int,
    val name: String,
    val sellingPrice: Double,
    val purchasePrice: Double,
    val quantity: Double,
    val isAvailable: Boolean = true,

    val color: String? = null,
    val volume: Double? = null
)
