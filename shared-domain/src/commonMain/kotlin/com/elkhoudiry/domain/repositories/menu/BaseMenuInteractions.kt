package com.elkhoudiry.domain.repositories.menu

import com.elkhoudiry.domain.items.models.Item
import kotlinx.coroutines.flow.SharedFlow

interface BaseMenuInteractions {

    fun listen(): SharedFlow<Item>

    suspend fun itemClick(item: Item)
}
