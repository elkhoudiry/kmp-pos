package com.elkhoudiry.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.elkhoudiry.ui.helpers.englishFont

private val Raleway = FontFamily(
    englishFont()
)

val Typography = Typography(
    defaultFontFamily = Raleway, h1 = TextStyle(
        fontSize = 30.sp,
    ), h2 = TextStyle(
        fontSize = 26.sp,
    ), h3 = TextStyle(
        fontSize = 24.sp,
    ), h4 = TextStyle(
        fontSize = 20.sp,
    ), subtitle1 = TextStyle(
        fontSize = 18.sp
    ), body1 = TextStyle(
        fontSize = 16.sp,
    ), body2 = TextStyle(
        fontSize = 14.sp,
    ), caption = TextStyle(
        fontSize = 11.sp, fontWeight = FontWeight.Medium
    )
)