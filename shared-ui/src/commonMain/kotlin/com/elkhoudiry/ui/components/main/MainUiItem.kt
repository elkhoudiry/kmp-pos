package com.elkhoudiry.ui.components.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor

@Composable
fun MainUiItem(
    modifier: Modifier,
    item: String,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier.clickable { onClick() },
        elevation = AppTheme.dimens.menuCellElevation.dp,
        shape = AppTheme.shapes.small
    ) {
        Column(
            modifier = Modifier.padding(AppTheme.dimens.menuCellPadding.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item,
                color = AppTheme.colors.onSurface.toColor(),
                style = AppTheme.type.body1
            )
        }
    }
}
