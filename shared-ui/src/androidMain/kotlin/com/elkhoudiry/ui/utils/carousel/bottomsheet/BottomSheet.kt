package com.elkhoudiry.ui.utils.carousel.bottomsheet

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BottomSheet(
    normalContent: @Composable () -> Unit,
    collapsed: @Composable () -> Unit,
    expanded: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )
    val sheetToggle: () -> Unit = {
        scope.launch {
            if (scaffoldState.bottomSheetState.isCollapsed) {
                scaffoldState.bottomSheetState.expand()
            } else {
                scaffoldState.bottomSheetState.collapse()
            }
        }
    }
    val radius = (30 * scaffoldState.currentFraction).dp

    BottomSheetScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        sheetShape = RoundedCornerShape(
            topStart = radius,
            topEnd = radius
        ),
        sheetContent = {
            SheetContent {
                SheetExpanded {
                    expanded()
                }
                SheetCollapsed(
                    isCollapsed = scaffoldState.bottomSheetState.isCollapsed,
                    currentFraction = scaffoldState.currentFraction,
                    onSheetClick = sheetToggle
                ) {
                    collapsed()
                }
            }
        },
        sheetPeekHeight = 60.dp,
    ) {
        normalContent()
    }
}

@ExperimentalMaterialApi
val BottomSheetScaffoldState.currentFraction: Float
    get() {
        val fraction = bottomSheetState.progress.fraction
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        return when {
            currentValue == BottomSheetValue.Collapsed &&
                targetValue == BottomSheetValue.Collapsed -> 0f
            currentValue == BottomSheetValue.Expanded &&
                targetValue == BottomSheetValue.Expanded -> 1f
            currentValue == BottomSheetValue.Collapsed &&
                targetValue == BottomSheetValue.Expanded -> fraction
            else -> 1f - fraction
        }
    }
