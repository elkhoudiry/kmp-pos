package com.elkhoudiry.ui.destinations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.elkhoudiry.domain.navigation.models.NavDestination
import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.ui.components.main.MainUI
import com.elkhoudiry.ui.helpers.ResContext
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor

@Composable
actual fun MainScreen(
    navigationRepository: BaseNavigationRepository,
) {
    AppTheme {
        MainUI(
            modifier = Modifier.fillMaxSize().background(AppTheme.colors.background.toColor()),
            onSellClick = { navigationRepository.nav(NavDestination.Menu) },
            onWarehousesClick = { navigationRepository.nav(NavDestination.WareHouses) }
        )
    }
}