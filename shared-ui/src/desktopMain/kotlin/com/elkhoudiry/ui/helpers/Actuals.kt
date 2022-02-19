package com.elkhoudiry.ui.helpers

import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import com.elkhoudiry.ui.app.CommonGlobals
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

actual typealias ResContext = Any

actual fun englishFont(): Font {
    return androidx.compose.ui.text.platform.Font(resource = "font/raleway_tajwal_medium.ttf")
}

@Composable
actual fun getImageFromResource(resource: ImageResource): Painter {
    return painterResource("images/$resource")
}

actual fun isLTR(): Boolean {
    return true
}

actual fun getRotatedBackArrow(): ImageVector {
    return if (isLTR()) Icons.Default.ArrowBack else Icons.Default.ArrowForward
}

@Composable
actual fun DropdownMenu(expanded: Boolean, onDismissRequest: () -> Unit, content: @Composable ColumnScope.() -> Unit) {
    androidx.compose.material.DropdownMenu(
        expanded = expanded, onDismissRequest = onDismissRequest, content = content
    )
}

@Composable
actual fun DropdownMenuItem(modifier: Modifier, onClick: () -> Unit, content: @Composable RowScope.() -> Unit) {
    androidx.compose.material.DropdownMenuItem(modifier = modifier, onClick = onClick, content = content)
}

@Composable
actual fun VerticalScrollbar(modifier: Modifier, state: LazyListState) {
    androidx.compose.foundation.VerticalScrollbar(
        modifier = modifier,
        adapter = rememberScrollbarAdapter(scrollState = state),
        style = LocalScrollbarStyle.current.copy(unhoverColor = AppTheme.colors.primary.toColor().copy(alpha = 0.3f))
    )
}

@Composable
actual fun VerticalScrollbar(modifier: Modifier, state: ScrollState) {
    androidx.compose.foundation.VerticalScrollbar(
        modifier = modifier,
        adapter = rememberScrollbarAdapter(scrollState = state),
        style = LocalScrollbarStyle.current.copy(unhoverColor = AppTheme.colors.primary.toColor().copy(alpha = 0.3f))
    )
}

@Composable
actual fun HorizontalScrollbar(modifier: Modifier, state: LazyListState) {
    androidx.compose.foundation.HorizontalScrollbar(
        modifier = modifier,
        adapter = rememberScrollbarAdapter(scrollState = state),
        style = LocalScrollbarStyle.current.copy(unhoverColor = AppTheme.colors.primary.toColor().copy(alpha = 0.3f))
    )
}

@Composable
actual fun HorizontalScrollbar(modifier: Modifier, state: ScrollState) {
    androidx.compose.foundation.HorizontalScrollbar(
        modifier = modifier,
        adapter = rememberScrollbarAdapter(scrollState = state),
        style = LocalScrollbarStyle.current.copy(unhoverColor = AppTheme.colors.primary.toColor().copy(alpha = 0.3f))
    )
}

actual fun getMRString(resource: StringResource, context: ResContext): String {
    return resource.localized()
}
