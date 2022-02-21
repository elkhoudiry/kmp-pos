package com.elkhoudiry.presentation.theme

data class ColorPallet(
    val primary: Long = 0xFF000000,
    val onPrimary: Long = 0xFFFFFFFF,
    val primaryVariant: Long = 0xFF3700B3,

    val secondary: Long = 0xFF03DAC6,
    val onSecondary: Long = 0xFF000000,
    val secondaryVariant: Long = 0xFF018786,

    val background: Long = 0xFFF4F4F4,
    val onBackground: Long = 0xFF000000,

    val surface: Long = 0xFFFFFFFF,
    val onSurface: Long = 0xFF000000,

    val error: Long = 0xFFB00020,
    val onError: Long = 0xFFFFFFFF,

    val cancel: Long = 0xFFB00020,
    val onCancel: Long = 0xFFFFFFFF,

    val confirm: Long = 0xFF00BE09,
    val onConfirm: Long = 0xFFFFFFFF
)

val lightColors = ColorPallet()

val darkColors = ColorPallet(
    primary = 0xFF7E57C2,
    primaryVariant = 0xFF3700B3,
    secondary = 0xFF03DAC6,
    secondaryVariant = 0xFF03DAC6,
    background = 0xFF121212,
    surface = 0xFF222222,
    confirm = 0xFF2E7D32,
    error = 0xFFC62828,
    cancel = 0xFFC62828,
    onPrimary = 0xFFFFFFFF,
    onSecondary = 0xFF000000,
    onBackground = 0xFFFFFFFF,
    onSurface = 0xFFFFFFFF,
    onError = 0xFF000000
)
