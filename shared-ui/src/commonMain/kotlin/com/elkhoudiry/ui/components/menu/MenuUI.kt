package com.elkhoudiry.ui.components.menu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.domain.MR
import com.elkhoudiry.presentation.screens.menu.MenuEvent
import com.elkhoudiry.presentation.screens.menu.MenuState
import com.elkhoudiry.ui.app.CommonGlobals
import com.elkhoudiry.ui.helpers.DropdownMenu
import com.elkhoudiry.ui.helpers.DropdownMenuItem
import com.elkhoudiry.ui.helpers.getMRString
import com.elkhoudiry.ui.helpers.getRotatedBackArrow
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor
import com.elkhoudiry.ui.utils.spacing.MediumSpacerVertical
import com.elkhoudiry.ui.utils.spacing.SmallSpacerHorizontal

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MenuUI(
    modifier: Modifier,
    state: MenuState,
    onBackClick: () -> Unit,
    onEvent: (MenuEvent) -> Unit
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = getRotatedBackArrow(),
                    contentDescription = "",
                    tint = AppTheme.colors.onBackground.toColor()
                )
            }

            SmallSpacerHorizontal()

            Text(
                text = getMRString(MR.strings.menu, CommonGlobals.resContext),
                style = AppTheme.type.h1,
                color = AppTheme.colors.onBackground.toColor()
            )
        }

        MediumSpacerVertical()

        Row(verticalAlignment = Alignment.CenterVertically) {
            val expandedWarehouses = remember { mutableStateOf(false) }

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "",
                tint = AppTheme.colors.onBackground.toColor()
            )

            SmallSpacerHorizontal()

            Box {
                OutlinedButton(onClick = {
                    expandedWarehouses.value = !expandedWarehouses.value
                }) {
                    Text(
                        "${
                        getMRString(
                            MR.strings.warehouse,
                            CommonGlobals.resContext
                        )
                        }: ${state.getSelectedWarehouseName()}"
                    )
                }

                DropdownMenu(expanded = expandedWarehouses.value, onDismissRequest = {
                    expandedWarehouses.value = false
                }) {
                    for (warehouse in state.warehouses) {
                        DropdownMenuItem(modifier = Modifier, onClick = {
                            onEvent(MenuEvent.OnWarehouseFilter(warehouse))
                            expandedWarehouses.value = false
                        }) {
                            Text(warehouse.name)
                        }
                    }

                    DropdownMenuItem(modifier = Modifier, onClick = {
                        expandedWarehouses.value = false
                    }) {
                        Text(getMRString(MR.strings.cancel, CommonGlobals.resContext))
                    }
                }
            }
        }

        MediumSpacerVertical()

        LazyVerticalGrid(
            cells = GridCells.Adaptive(AppTheme.dimens.menuCellMinHeight.dp),
        ) {
            itemsIndexed(state.getFilteredAvailableItems()) { index, item ->
                MenuItem(
                    modifier = Modifier.height(AppTheme.dimens.menuCellMinHeight.dp)
                        .padding(AppTheme.dimens.checkoutItemPadding.dp),
                    item = item,
                    onClick = { onEvent(MenuEvent.OnMenuItemClick(item)) }
                )
            }
        }

        MediumSpacerVertical()

        LazyVerticalGrid(
            cells = GridCells.Adaptive(AppTheme.dimens.menuCellMinHeight.dp),
        ) {
            itemsIndexed(state.getFilteredNotAvailableItems()) { index, item ->
                MenuItem(
                    modifier = Modifier.height(AppTheme.dimens.menuCellMinHeight.dp)
                        .padding(AppTheme.dimens.checkoutItemPadding.dp),
                    item = item,
                    onClick = { onEvent(MenuEvent.OnMenuItemClick(item)) }
                )
            }
        }
    }
}
