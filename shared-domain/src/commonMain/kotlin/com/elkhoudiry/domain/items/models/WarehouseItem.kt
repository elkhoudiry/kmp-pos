package com.elkhoudiry.domain.items.models

data class WarehouseItem(
    override val id: Int,
    override val code: Int,
    override val name: String,
    override val sellingPrice: Double,
    override val purchasePrice: Double,

    val quantity: Double,
    val isAvailable: Boolean = true,
) : Item()


