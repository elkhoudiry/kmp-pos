package com.elkhoudiry.ui.utils.carousel.bottomsheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SheetContent(
    heightFraction: Float = 0.9f, content: @Composable BoxScope.() -> Unit
) {
    Box(
        Modifier.fillMaxWidth().fillMaxHeight(fraction = heightFraction)
    ) {
        content()
    }
}