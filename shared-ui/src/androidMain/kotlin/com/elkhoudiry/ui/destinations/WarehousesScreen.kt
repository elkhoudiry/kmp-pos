package com.elkhoudiry.ui.destinations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.domain.navigation.models.NavDestination
import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.presentation.screens.warehouses.WarehousesEvent
import com.elkhoudiry.domain.MR
import com.elkhoudiry.ui.app.CommonGlobals
import com.elkhoudiry.ui.components.warehouses.WarehousesMain
import com.elkhoudiry.ui.components.warehouses.WarehousesSide
import com.elkhoudiry.ui.helpers.getMRString
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor
import com.elkhoudiry.ui.utils.carousel.bottomsheet.BottomSheet
import com.elkhoudiry.ui.viewmodels.WarehousesPlatformViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
actual fun WarehousesScreen(
    warehousesViewModel: WarehousesPlatformViewModel, navigationRepository: BaseNavigationRepository
) {
    val state = warehousesViewModel.getState().collectAsState().value

    AppTheme {
        BottomSheet(normalContent = {
            WarehousesMain(modifier = Modifier.fillMaxSize().background(AppTheme.colors.background.toColor())
                .padding(AppTheme.dimens.componentPadding.dp),
                state = state,
                onBackClick = { navigationRepository.nav(NavDestination.Main) })
        }, collapsed = {
            Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(
                    "${getMRString(MR.strings.warehouse, CommonGlobals.resContext)}: ${state.warehouses[state.selectedWarehouse].name}",
                    color = AppTheme.colors.onPrimary.toColor()
                )
            }
        },
        expanded = {
            WarehousesSide(
                modifier = Modifier.fillMaxSize(),
                state = state,
                onWarehouseClick = { warehousesViewModel.onEvent(WarehousesEvent.OnWarehouseClick(it)) }
            )
        })
    }
}