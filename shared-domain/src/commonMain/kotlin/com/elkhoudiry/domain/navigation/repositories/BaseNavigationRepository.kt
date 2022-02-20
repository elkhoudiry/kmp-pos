package com.elkhoudiry.domain.navigation.repositories

import com.elkhoudiry.domain.navigation.models.NavDestination
import kotlinx.coroutines.flow.SharedFlow

interface BaseNavigationRepository {

    fun listen(): SharedFlow<NavDestination>

    fun nav(to: NavDestination)
}
