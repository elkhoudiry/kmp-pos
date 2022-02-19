package com.elkhoudiry.domain.utils

fun <T> List<T>.added(item: T, at: Int = this.size): List<T> {
    return this.toMutableList().apply { add(at, item) }
}

fun <T> List<T>.removed(item: T): List<T> {
    return this.toMutableList().apply { remove(item) }
}

fun <T> List<T>.removed(index: Int): List<T> {
    return this.toMutableList().apply { removeAt(index) }
}

fun <T> List<T>.editedItem(item: T, condition: (T) -> Boolean): List<T> {
    return toMutableList().let { list ->
        val index = indexOfFirst { condition(it) }
        if (index != -1) {
            list.removeAt(index)
            list.add(index, item)
        }
        list
    }
}