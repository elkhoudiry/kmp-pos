package com.elkhoudiry.di

import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.pos.AppDatabase
import com.elkhoudiry.ui.viewmodels.CheckoutPlatformViewModel
import com.elkhoudiry.ui.viewmodels.MenuPlatformViewModel
import com.elkhoudiry.ui.viewmodels.WarehousesPlatformViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object Inject : KoinComponent {
    private val menuPlatformViewModel: MenuPlatformViewModel by inject()

    private val checkoutPlatformViewMode: CheckoutPlatformViewModel by inject()

    private val warehousesPlatformViewModel: WarehousesPlatformViewModel by inject()

    private val navRepository: BaseNavigationRepository by inject()

    private val appDatabase: AppDatabase by inject()

    fun navRepository() = navRepository

    fun menuPlatformViewModel() = menuPlatformViewModel

    fun checkoutPlatformViewModel() = checkoutPlatformViewMode

    fun warehousesPlatformViewModel() = warehousesPlatformViewModel

    fun appDatabase() = appDatabase
}
