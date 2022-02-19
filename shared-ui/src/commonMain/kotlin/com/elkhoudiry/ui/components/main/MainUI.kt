package com.elkhoudiry.ui.components.main

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.domain.MR
import com.elkhoudiry.ui.app.CommonGlobals
import com.elkhoudiry.ui.helpers.getMRString
import com.elkhoudiry.ui.theme.AppTheme

@Composable
fun MainUI(
    modifier: Modifier, onSellClick: () -> Unit, onWarehousesClick: () -> Unit
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
        MainUiItem(
            modifier = Modifier
                .height(AppTheme.dimens.menuCellMinHeight.dp)
                .width(AppTheme.dimens.menuCellMinWidth.dp)
                .padding(AppTheme.dimens.checkoutItemPadding.dp),
            item = getMRString(MR.strings.sell, CommonGlobals.resContext),
            onClick = onSellClick
        )

        MainUiItem(
            modifier = Modifier
                .height(AppTheme.dimens.menuCellMinHeight.dp)
                .width(AppTheme.dimens.menuCellMinWidth.dp)
                .padding(AppTheme.dimens.checkoutItemPadding.dp),
            item = getMRString(MR.strings.warehouses, CommonGlobals.resContext),
            onClick = onWarehousesClick
        )
    }
}