package com.elkhoudiry.domain.navigation.models

sealed class NavDestination {

    object Main : NavDestination()

    object Menu : NavDestination()

    object WareHouses : NavDestination()

    object NONE: NavDestination()
}