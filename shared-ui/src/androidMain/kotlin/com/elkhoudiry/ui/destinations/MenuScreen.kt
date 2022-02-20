package com.elkhoudiry.ui.destinations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.domain.MR
import com.elkhoudiry.domain.navigation.models.NavDestination
import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.ui.app.CommonGlobals
import com.elkhoudiry.ui.components.checkout.SideCheckoutUI
import com.elkhoudiry.ui.components.menu.MenuUI
import com.elkhoudiry.ui.helpers.getMRString
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor
import com.elkhoudiry.ui.utils.carousel.bottomsheet.BottomSheet
import com.elkhoudiry.ui.viewmodels.CheckoutPlatformViewModel
import com.elkhoudiry.ui.viewmodels.MenuPlatformViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
actual fun MenuScreen(
    menuViewModel: MenuPlatformViewModel,
    checkoutViewModel: CheckoutPlatformViewModel,
    navRepository: BaseNavigationRepository,
) {
    AppTheme {
        BottomSheet(
            collapsed = {
                val state = checkoutViewModel
                    .getState()
                    .collectAsState().value
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${
                        getMRString(
                            MR.strings.count,
                            CommonGlobals.resContext
                        )
                        }: ${state.checkoutItemsCount()}" + " ${
                        getMRString(
                            MR.strings.total,
                            CommonGlobals.resContext
                        )
                        }: ${state.checkoutItemsTotal()} $",
                        color = AppTheme.colors.onPrimary.toColor()
                    )

                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "",
                        tint = AppTheme.colors.onPrimary.toColor()
                    )
                }
            },
            expanded = {
                SideCheckoutUI(
                    modifier = Modifier.fillMaxSize(),
                    state = checkoutViewModel
                        .getState()
                        .collectAsState().value,
                    onEvent = { checkoutViewModel.onEvent(it) }
                )
            },
            normalContent = {
                MenuUI(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(AppTheme.colors.background.toColor())
                        .padding(AppTheme.dimens.componentPadding.dp),
                    state = menuViewModel
                        .getState()
                        .collectAsState().value,
                    onBackClick = { navRepository.nav(NavDestination.Main) },
                    onEvent = { menuViewModel.onEvent(it) }
                )
            }
        )
    }
}
