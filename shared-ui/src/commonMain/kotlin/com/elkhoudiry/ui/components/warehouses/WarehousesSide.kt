package com.elkhoudiry.ui.components.warehouses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.presentation.screens.warehouses.WarehousesState
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor

@Composable
fun WarehousesSide(
    modifier: Modifier, state: WarehousesState, onWarehouseClick: (Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier.background(AppTheme.colors.background.toColor())
            .padding(AppTheme.dimens.componentPadding.dp)
    ) {
        itemsIndexed(state.warehouses) { index, warehouse ->
            WarehousesSideItem(
                modifier = Modifier.fillMaxWidth().height(AppTheme.dimens.warehouseItemHeight.dp),
                warehouse = warehouse,
                isSelected = state.selectedWarehouse == index,
                onClick = onWarehouseClick
            )
        }
    }
}