package com.elkhoudiry.ui.utils.spacing

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.ui.theme.AppTheme

@Composable
fun SmallSpacerVertical() {
    Spacer(Modifier.height(AppTheme.dimens.smallSpacing.dp))
}

@Composable
fun SmallSpacerHorizontal() {
    Spacer(Modifier.width(AppTheme.dimens.smallSpacing.dp))
}

@Composable
fun MediumSpacerVertical() {
    Spacer(Modifier.height(AppTheme.dimens.mediumSpacing.dp))
}

@Composable
fun MediumSpacerHorizontal() {
    Spacer(Modifier.width(AppTheme.dimens.mediumSpacing.dp))
}

@Composable
fun LargeSpacerVertical() {
    Spacer(Modifier.height(AppTheme.dimens.largeSpacing.dp))
}

@Composable
fun LargeSpacerHorizontal() {
    Spacer(Modifier.width(AppTheme.dimens.largeSpacing.dp))
}