package com.elkhoudiry.ui.helpers

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import dev.icerock.moko.resources.StringResource

expect class ResContext

expect fun englishFont(): Font

expect fun getImageFromResource(resource: ImageResource): Painter

expect fun isLTR(): Boolean

expect fun getRotatedBackArrow(): ImageVector

@Composable
expect fun DropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
)

@Composable
expect fun DropdownMenuItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
)

@Composable
expect fun VerticalScrollbar(modifier: Modifier, state: LazyListState)

@Composable
expect fun VerticalScrollbar(modifier: Modifier, state: ScrollState)

@Composable
expect fun HorizontalScrollbar(modifier: Modifier, state: LazyListState)

@Composable
expect fun HorizontalScrollbar(modifier: Modifier, state: ScrollState)

expect fun getMRString(resource: StringResource, context: ResContext): String
