package com.elkhoudiry.ui.components.checkout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elkhoudiry.domain.MR
import com.elkhoudiry.presentation.screens.checkout.CheckoutEvent
import com.elkhoudiry.presentation.screens.checkout.CheckoutState
import com.elkhoudiry.ui.app.CommonGlobals
import com.elkhoudiry.ui.helpers.getMRString
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor
import com.elkhoudiry.ui.utils.scrollbars.simpleVerticalScrollbar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SideCheckoutUI(modifier: Modifier, state: CheckoutState, onEvent: (CheckoutEvent) -> Unit) {
    val lazyState = rememberLazyListState()

    Column(
        modifier = modifier
            .background(AppTheme.colors.background.toColor())
            .padding(AppTheme.dimens.componentPadding.dp)
    ) {
        LazyColumn(
            modifier = Modifier.weight(6f).simpleVerticalScrollbar(lazyState),
            state = lazyState
        ) {
            itemsIndexed(state.items().keys.toList()) { index, item ->
                SideCheckoutItem(
                    modifier = Modifier
                        .height(AppTheme.dimens.checkoutItemHeight.dp)
                        .padding(AppTheme.dimens.checkoutItemPadding.dp)
                        .combinedClickable(
                            onClick = {
                                onEvent(CheckoutEvent.ItemClick(state.items()[item]!![0]))
                            },
                            onLongClick = { }
                        ),
                    items = state.items()[item]!!
                )
            }
        }

        Column(
            modifier = Modifier.weight(2f), verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                text = "${
                getMRString(MR.strings.total, CommonGlobals.resContext)
                }: ${
                state.totalPrice()
                } $",
                color = AppTheme.colors.onBackground.toColor(),
                style = AppTheme.type.h1
            )

            Spacer(Modifier.height(20.dp))

            Row {
                OutlinedButton(
                    modifier = Modifier.height(AppTheme.dimens.checkoutClearButtonHeight.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = AppTheme.colors.cancel.toColor(),
                        backgroundColor = Color.Transparent
                    ),
                    border = BorderStroke(1.dp, AppTheme.colors.cancel.toColor()),
                    onClick = { onEvent(CheckoutEvent.ClearItems) }
                ) {
                    Text(getMRString(MR.strings.cancel, CommonGlobals.resContext).uppercase())
                }

                Spacer(Modifier.width(10.dp))

                Button(
                    modifier = Modifier
                        .weight(5f)
                        .height(AppTheme.dimens.checkoutClearButtonHeight.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = AppTheme.colors.confirm.toColor(),
                        contentColor = AppTheme.colors.onConfirm.toColor()
                    ),
                    onClick = { onEvent(CheckoutEvent.ClearItems) }
                ) {
                    Text(getMRString(MR.strings.confirm, CommonGlobals.resContext).uppercase())
                }
            }
        }
    }
}
