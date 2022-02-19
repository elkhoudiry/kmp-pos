package com.elkhoudiry.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.elkhoudiry.presentation.theme.ColorPallet
import com.elkhoudiry.presentation.theme.Dimensions
import com.elkhoudiry.presentation.theme.darkColors
import com.elkhoudiry.presentation.theme.normalDimensions

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit
) {
    val palette = if (darkTheme) darkColors else com.elkhoudiry.presentation.theme.lightColors

    val dimensions = normalDimensions

    val shapes = Shapes

    val type = Typography

    ProvideTypography(type){
        ProvideShapes(shapes = shapes) {
            ProvideAppColors(colors = palette, isLight = !darkTheme) {
                ProvideDimens(dimensions = dimensions) {
                    MaterialTheme(
                        colors = palette.toColors(!darkTheme), typography = type, shapes = shapes, content = content
                    )
                }
            }
        }
    }
}

object AppTheme {

    val dimens: Dimensions
        @Composable get() = LocalAppDimens.current

    val colors: ColorPallet
        @Composable get() = localAppColors(!isSystemInDarkTheme()).current

    val shapes: Shapes
        @Composable get() = LocalAppShapes.current

    val type: Typography
        @Composable get() = LocalAppTypography.current
}

private fun ColorPallet.toColors(isLight: Boolean): Colors {
    lightColors()
    return Colors(
        primary = Color(primary),
        primaryVariant = Color(primaryVariant),
        secondary = Color(secondary),
        secondaryVariant = Color(secondaryVariant),
        background = Color(background),
        surface = Color(surface),
        error = Color(error),
        onPrimary = Color(onPrimary),
        onSecondary = Color(onSecondary),
        onBackground = Color(onBackground),
        onSurface = Color(onSurface),
        onError = Color(onError),
        isLight = isLight
    )
}

@Composable
fun ProvideAppColors(
    colors: ColorPallet, isLight: Boolean, content: @Composable () -> Unit
) {
    val colorPalette = remember { colors }
    CompositionLocalProvider(
        localAppColors(isLight) provides colorPalette, content = content
    )
}

private fun localAppColors(isLight: Boolean) = staticCompositionLocalOf {
    if (isLight) com.elkhoudiry.presentation.theme.lightColors else darkColors
}

@Composable
fun ProvideDimens(
    dimensions: Dimensions, content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(
        LocalAppDimens provides dimensionSet, content = content
    )
}

@Composable
fun ProvideShapes(
    shapes: Shapes, content: @Composable () -> Unit
) {
    val dimensionSet = remember { shapes }
    CompositionLocalProvider(
        LocalAppShapes provides dimensionSet, content = content
    )
}

@Composable
fun ProvideTypography(
    type: Typography, content: @Composable () -> Unit
) {
    val typeSet = remember { type }
    CompositionLocalProvider(
        LocalAppTypography provides typeSet, content = content
    )
}


val LocalAppDimens = staticCompositionLocalOf {
    normalDimensions
}

val LocalAppShapes = staticCompositionLocalOf {
    Shapes
}

val LocalAppTypography = staticCompositionLocalOf {
    Typography
}

fun Long.toColor(): Color = Color(this)