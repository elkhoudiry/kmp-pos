package com.elkhoudiry.ui.destinations

import androidx.compose.runtime.Composable
import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.ui.helpers.ResContext
import com.elkhoudiry.ui.viewmodels.CheckoutPlatformViewModel
import com.elkhoudiry.ui.viewmodels.MenuPlatformViewModel

@Composable
expect fun MenuScreen(
    menuViewModel: MenuPlatformViewModel,
    checkoutViewModel: CheckoutPlatformViewModel,
    navRepository: BaseNavigationRepository
)

