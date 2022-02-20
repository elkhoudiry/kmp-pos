package com.elkhoudiry.domain.repositories.menu

import com.elkhoudiry.domain.items.models.ListingItem
import kotlinx.coroutines.flow.SharedFlow

interface BaseMenuInteractions {

    fun listen(): SharedFlow<ListingItem>

    suspend fun itemClick(item: ListingItem)
}
