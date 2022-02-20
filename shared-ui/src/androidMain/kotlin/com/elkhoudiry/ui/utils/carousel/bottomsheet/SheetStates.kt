package com.elkhoudiry.ui.utils.carousel.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor

@Composable
fun SheetExpanded(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.primary.toColor())
            .padding(top = 60.dp)
    ) {
        content()
    }
}

@Composable
fun SheetCollapsed(
    isCollapsed: Boolean,
    currentFraction: Float,
    onSheetClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(AppTheme.colors.primary.toColor())
            .noRippleClickable(
                onClick = onSheetClick,
                enabled = isCollapsed
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}
