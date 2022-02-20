package com.elkhoudiry.ui.destinations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkhoudiry.domain.navigation.models.NavDestination
import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.ui.components.checkout.SideCheckoutUI
import com.elkhoudiry.ui.components.menu.MenuUI
import com.elkhoudiry.ui.theme.AppTheme
import com.elkhoudiry.ui.theme.toColor
import com.elkhoudiry.ui.utils.spacing.SmallSpacerHorizontal
import com.elkhoudiry.ui.viewmodels.CheckoutPlatformViewModel
import com.elkhoudiry.ui.viewmodels.MenuPlatformViewModel

@Composable
actual fun MenuScreen(
    menuViewModel: MenuPlatformViewModel,
    checkoutViewModel: CheckoutPlatformViewModel,
    navRepository: BaseNavigationRepository
) {
    AppTheme {
        Row(
            Modifier.fillMaxSize()
        ) {
            MenuUI(
                modifier = Modifier.weight(3f).fillMaxSize()
                    .background(AppTheme.colors.background.toColor())
                    .padding(AppTheme.dimens.componentPadding.dp),
                state = menuViewModel.getState().collectAsState().value,
                onBackClick = { navRepository.nav(NavDestination.Main) },
                onEvent = { menuViewModel.onEvent(it) }
            )

            SmallSpacerHorizontal()

            SideCheckoutUI(
                modifier = Modifier.weight(1f).fillMaxSize(),
                state = checkoutViewModel.getState().collectAsState().value,
                onEvent = { checkoutViewModel.onEvent(it) }
            )
        }
    }
}
