package com.elkhoudiry.domain.items.models

abstract class Item(){
    abstract val id: Int
    abstract val code: Int
    abstract val name: String
    abstract val sellingPrice: Double
    abstract val purchasePrice: Double
}
