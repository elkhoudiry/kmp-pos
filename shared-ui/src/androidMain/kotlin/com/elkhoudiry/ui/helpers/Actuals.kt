package com.elkhoudiry.ui.helpers

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.View
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import com.elkhoudiry.common.R
import com.elkhoudiry.ui.app.CommonGlobals
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

actual typealias ResContext = Application

actual fun englishFont(): Font {
    return Font(resId = R.font.raleway_tajwal_regular)
}

@Composable
actual fun getImageFromResource(resource: ImageResource): Painter {
    return painterResource(resource)
}

actual fun isLTR(): Boolean {
    return (CommonGlobals.resContext as Context).resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_LTR
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

}

@Composable
actual fun VerticalScrollbar(modifier: Modifier, state: ScrollState) {

}

@Composable
actual fun HorizontalScrollbar(modifier: Modifier, state: LazyListState) {

}

@Composable
actual fun HorizontalScrollbar(modifier: Modifier, state: ScrollState) {

}

@Composable
actual fun getMRString(resource: StringResource, context: ResContext): String {
    Log.d("TAGGY", "locale: ${context.resources.configuration.locale}")
    return StringDesc.Resource(resource).toString(context)
}
