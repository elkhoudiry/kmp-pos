package com.elkhoudiry.presentation.components.navbars

import com.elkhoudiry.domain.navigation.models.NavDestination

data class NavBarItem(
    val title: String,
    val enabled: Boolean,
    val destination: NavDestination
)
