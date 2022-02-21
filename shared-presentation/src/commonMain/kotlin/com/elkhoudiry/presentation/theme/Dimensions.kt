package com.elkhoudiry.presentation.theme

data class Dimensions(
    val scale: Int
) {
    val miniSpacing: Int = scale * 2
    val smallSpacing: Int = scale * 8
    val mediumSpacing: Int = scale * 16
    val largeSpacing: Int = scale * 24

    val mainGridMinSize: Int = scale * 200

    val menuCellMinHeight: Int = scale * 100
    val menuCellMinWidth: Int = scale * 120
    val menuCellPadding: Int = scale * 4
    val menuCellElevation: Int = scale * 2

    val screenPadding: Int = scale * 8
    val componentPadding: Int = scale * 8

    val checkoutItemElevation: Int = scale * 2
    val checkoutItemPadding: Int = scale * 4
    val checkoutItemHeight: Int = scale * 100
    val checkoutClearButtonHeight: Int = scale * 60

    val navItemHeight: Int = scale * 50
    val navItemPadding: Int = scale * 8

    val warehouseItemPadding: Int = scale * 4
    val warehouseItemElevation: Int = scale * 2
    val warehouseItemHeight: Int = scale * 100

    val warehouseListingItemPadding: Int = scale * 4
    val warehouseListingItemElevation: Int = scale * 2
}

val normalDimensions = Dimensions(1)
