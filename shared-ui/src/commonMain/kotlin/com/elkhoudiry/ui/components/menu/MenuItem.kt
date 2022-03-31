package com.elkhoudiry.ui.components.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.elkhoudiry.domain.items.models.Item
import com.elkhoudiry.domain.items.models.WarehouseItem
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor

@Composable
fun MenuItem(modifier: Modifier, item: WarehouseItem, onClick: () -> Unit) {
    if (item.isAvailable) {
        BaseMenuItem(modifier = modifier, item = item, onClick = onClick)
    } else {
        BaseMenuItem(
            modifier = modifier,
            item = item,
            onClick = onClick,
            clickable = false,
            strikethrough = true
        )
    }
}

@Composable
private fun BaseMenuItem(
    modifier: Modifier,
    item: Item,
    onClick: () -> Unit,
    clickable: Boolean = true,
    strikethrough: Boolean = false
) {
    Surface(
        modifier = modifier.clickable(enabled = clickable) { onClick() },
        elevation = AppTheme.dimens.menuCellElevation.dp,
        shape = AppTheme.shapes.small
    ) {
        Column(
            modifier = Modifier.padding(AppTheme.dimens.menuCellPadding.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.name, color = AppTheme.colors.onSurface.toColor(),
                style = getTextStyle(strikethrough),
            )
            Text(
                text = item.sellingPrice.toString(),
                color = AppTheme.colors.onSurface.toColor(),
                style = getTextStyle(strikethrough)
            )
        }
    }
}

@Composable
private fun getTextStyle(strikethrough: Boolean): TextStyle {
    val style = AppTheme.type.body1
    return if (!strikethrough) style else style.copy(textDecoration = TextDecoration.LineThrough)
}
