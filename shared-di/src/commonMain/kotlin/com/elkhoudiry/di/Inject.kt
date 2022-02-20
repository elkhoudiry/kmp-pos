package com.elkhoudiry.di

import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.presentation.screens.checkout.CheckoutViewModel
import com.elkhoudiry.presentation.screens.menu.MenuViewModel
import com.elkhoudiry.presentation.screens.warehouses.WarehousesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object Inject : KoinComponent {
    private val menuViewModel: MenuViewModel by inject()

    private val checkoutViewModel: CheckoutViewModel by inject()

    private val warehousesViewModel: WarehousesViewModel by inject()

    private val navRepository: BaseNavigationRepository by inject()

    fun navRepository() = navRepository

    fun menuViewModel() = menuViewModel

    fun checkoutViewModel() = checkoutViewModel

    fun warehousesViewModel() = warehousesViewModel
}
