package com.elkhoudiry.data.repositories.menu

import com.elkhoudiry.domain.items.models.Item
import com.elkhoudiry.domain.repositories.menu.BaseMenuInteractions
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class MenuInteractions : BaseMenuInteractions {

    private val flow = MutableSharedFlow<Item>(0)

    override fun listen(): SharedFlow<Item> {
        return flow
    }

    override suspend fun itemClick(item: Item) {
        flow.emit(item)
    }
}
