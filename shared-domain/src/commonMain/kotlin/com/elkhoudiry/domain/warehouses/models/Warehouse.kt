package com.elkhoudiry.domain.warehouses.models

import com.elkhoudiry.domain.items.models.ListingItem

data class Warehouse(
    val id: Int,
    val name: String,
    val items: List<ListingItem>
)
