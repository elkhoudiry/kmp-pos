package com.elkhoudiry.ui.components.warehouses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.elkhoudiry.domain.MR
import com.elkhoudiry.presentation.screens.warehouses.WarehousesState
import com.elkhoudiry.ui.app.CommonGlobals
import com.elkhoudiry.ui.helpers.getMRString
import com.elkhoudiry.ui.helpers.getRotatedBackArrow
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor
import com.elkhoudiry.ui.utils.spacing.MediumSpacerVertical
import com.elkhoudiry.ui.utils.spacing.SmallSpacerHorizontal
import com.elkhoudiry.ui.utils.tables.DynamicTable

@Composable
fun WarehousesMain(
    modifier: Modifier,
    state: WarehousesState,
    onBackClick: () -> Unit
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
                text = getMRString(MR.strings.warehouses, CommonGlobals.resContext),
                style = AppTheme.type.h1,
                color = AppTheme.colors.onBackground.toColor()
            )
        }

        MediumSpacerVertical()

        DynamicTable(
            titles = listOf(
                getMRString(MR.strings.code, CommonGlobals.resContext),
                getMRString(MR.strings.name, CommonGlobals.resContext),
                getMRString(MR.strings.purchace_price, CommonGlobals.resContext),
                getMRString(MR.strings.selling_price, CommonGlobals.resContext),
                getMRString(MR.strings.available, CommonGlobals.resContext),
            ),
            contents = mapOf(
                getMRString(MR.strings.code, CommonGlobals.resContext) to state.items()
                    .map { it.code },
                getMRString(MR.strings.name, CommonGlobals.resContext) to state.items()
                    .map { it.name },
                getMRString(MR.strings.purchace_price, CommonGlobals.resContext) to state.items()
                    .map { it.purchasePrice },
                getMRString(MR.strings.selling_price, CommonGlobals.resContext) to state.items()
                    .map { it.sellingPrice },
                getMRString(MR.strings.available, CommonGlobals.resContext) to state.items()
                    .map { it.isAvailable },
            )
        )
    }
}
