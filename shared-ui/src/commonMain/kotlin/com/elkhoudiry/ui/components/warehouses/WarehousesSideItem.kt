package com.elkhoudiry.ui.components.warehouses

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elkhoudiry.domain.warehouses.models.Warehouse
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor

@Composable
fun WarehousesSideItem(
    modifier: Modifier,
    warehouse: Warehouse,
    isSelected: Boolean,
    onClick: (Int) -> Unit,
) {
    Surface(
        modifier = modifier.padding(AppTheme.dimens.warehouseItemPadding.dp)
            .clickable { onClick(warehouse.id) },
        elevation = AppTheme.dimens.warehouseItemElevation.dp,
        color = getSurfaceColor(isSelected),
        shape = AppTheme.shapes.small
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = warehouse.name,
                style = AppTheme.type.body1,
                color = getTextColor(isSelected)
            )
        }
    }
}

@Composable
private fun getSurfaceColor(isSelected: Boolean): Color {
    return if (isSelected) {
        AppTheme.colors.primary.toColor()
    } else {
        AppTheme.colors.surface.toColor()
    }
}

@Composable
private fun getTextColor(isSelected: Boolean): Color {
    return if (isSelected) {
        AppTheme.colors.onPrimary.toColor()
    } else {
        AppTheme.colors.onSurface.toColor()
    }
}
