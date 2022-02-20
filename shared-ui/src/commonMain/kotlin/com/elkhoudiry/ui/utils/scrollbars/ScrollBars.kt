package com.elkhoudiry.ui.utils.scrollbars

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor

@Composable
fun Modifier.simpleVerticalScrollbar(
    state: LazyListState,
    width: Dp = 2.dp,
    color: Color = AppTheme.colors.primary.toColor()
): Modifier {
    return drawWithContent {
        drawContent()

        val firstVisibleElementIndex = state.layoutInfo.visibleItemsInfo.firstOrNull()?.index

        if (firstVisibleElementIndex != null) {
            val elementHeight = this.size.height / state.layoutInfo.totalItemsCount
            val scrollbarOffsetY = firstVisibleElementIndex * elementHeight
            val scrollbarHeight = state.layoutInfo.visibleItemsInfo.size * elementHeight

            drawRect(
                color = color,
                topLeft = Offset(this.size.width - width.toPx(), scrollbarOffsetY),
                size = Size(width.toPx(), scrollbarHeight),
                alpha = 0.5f
            )
        }
    }
}

@Composable
fun Modifier.simpleHorizontalScrollbar(
    state: LazyListState,
    height: Dp = 2.dp,
    color: Color = AppTheme.colors.confirm.toColor()
): Modifier {
    return drawWithContent {
        drawContent()

        val firstVisibleElementIndex = state.layoutInfo.visibleItemsInfo.firstOrNull()?.index

        if (firstVisibleElementIndex != null) {
            val elementWidth = this.size.width / state.layoutInfo.totalItemsCount
            val scrollbarOffsetY = firstVisibleElementIndex * elementWidth
            val scrollbarWidth = state.layoutInfo.visibleItemsInfo.size * elementWidth

            drawRect(
                color = color,
                topLeft = Offset(this.size.height - height.toPx(), this.size.width),
                size = Size(scrollbarWidth, height.toPx()),
                alpha = 0.5f
            )
        }
    }
}
