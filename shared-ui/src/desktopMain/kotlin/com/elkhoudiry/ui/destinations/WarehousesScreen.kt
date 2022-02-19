package com.elkhoudiry.ui.destinations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.domain.navigation.models.NavDestination
import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.presentation.screens.warehouses.WarehousesEvent
import com.elkhoudiry.ui.components.warehouses.WarehousesMain
import com.elkhoudiry.ui.components.warehouses.WarehousesSide
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor
import com.elkhoudiry.ui.utils.spacing.SmallSpacerHorizontal
import com.elkhoudiry.ui.viewmodels.WarehousesPlatformViewModel

@Composable
actual fun WarehousesScreen(
    warehousesViewModel: WarehousesPlatformViewModel, navigationRepository: BaseNavigationRepository
) {
    val state = warehousesViewModel.getState().collectAsState().value

    AppTheme {
        Row(modifier = Modifier.fillMaxSize()) {
            WarehousesMain(modifier = Modifier.weight(3f).fillMaxSize()
                .background(AppTheme.colors.background.toColor()).padding(AppTheme.dimens.componentPadding.dp),
                state = state,
                onBackClick = { navigationRepository.nav(NavDestination.Main) })

            SmallSpacerHorizontal()

            WarehousesSide(
                modifier = Modifier.weight(1f).fillMaxSize(),
                state = state,
                onWarehouseClick = { warehousesViewModel.onEvent(WarehousesEvent.OnWarehouseClick(it)) }
            )
        }
    }
}