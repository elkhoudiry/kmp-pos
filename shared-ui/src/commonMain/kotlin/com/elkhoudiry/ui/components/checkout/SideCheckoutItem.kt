package com.elkhoudiry.ui.components.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.domain.MR
import com.elkhoudiry.domain.items.models.ListingItem
import com.elkhoudiry.ui.app.CommonGlobals
import com.elkhoudiry.ui.helpers.getMRString
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor

@Composable
fun SideCheckoutItem(
    modifier: Modifier,
    items: List<ListingItem>
) {
    Surface(
        modifier = modifier,
        shape = AppTheme.shapes.small,
        elevation = AppTheme.dimens.checkoutItemElevation.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(AppTheme.dimens.checkoutItemPadding.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = items[0].name,
                color = AppTheme.colors.onSurface.toColor(),
                style = AppTheme.type.body1
            )
            Text(
                text = items[0].sellingPrice.toString(),
                color = AppTheme.colors.onSurface.toColor(),
                style = AppTheme.type.body1
            )
            Text(text = "${getMRString(MR.strings.count, CommonGlobals.resContext)} ${items.size}")
        }
    }
}
