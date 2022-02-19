package com.elkhoudiry.ui.app

import com.elkhoudiry.data.navigation.repositories.NavigationRepository
import com.elkhoudiry.data.repositories.menu.MenuInteractions
import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.domain.repositories.menu.BaseMenuInteractions
import com.elkhoudiry.presentation.screens.checkout.CheckoutViewModel
import com.elkhoudiry.presentation.screens.menu.MenuViewModel
import com.elkhoudiry.presentation.screens.warehouses.WarehousesViewModel
import org.koin.dsl.module

val menuModule = module {
    single<BaseMenuInteractions> { MenuInteractions() }
    single<BaseNavigationRepository> { NavigationRepository() }
    single { MenuViewModel(get()) }
    single { CheckoutViewModel(get()) }
    single { WarehousesViewModel() }
}