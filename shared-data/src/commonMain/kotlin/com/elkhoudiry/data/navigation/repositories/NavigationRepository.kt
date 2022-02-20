package com.elkhoudiry.data.navigation.repositories

import com.elkhoudiry.domain.navigation.models.NavDestination
import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class NavigationRepository : BaseNavigationRepository {

    private val flow = MutableSharedFlow<NavDestination>(replay = 0)
    private var current = NavDestination.NONE::class

    override fun listen(): SharedFlow<NavDestination> {
        return flow
    }

    override fun nav(to: NavDestination) {
        if (to::class == current::class) return

        CoroutineScope(Dispatchers.Default).launch {
            flow.emit(to)
        }
    }
}
