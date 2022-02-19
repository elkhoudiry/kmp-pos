package com.elkhoudiry.data.repositories.menu

import com.elkhoudiry.domain.items.models.ListingItem
import com.elkhoudiry.domain.repositories.menu.BaseMenuInteractions
import kotlinx.coroutines.flow.*

class MenuInteractions : BaseMenuInteractions {

    private val flow = MutableSharedFlow<ListingItem>(0)

    override fun listen(): SharedFlow<ListingItem> {
        return flow
    }

    override suspend fun itemClick(item: ListingItem) {
        flow.emit(item)
    }
}