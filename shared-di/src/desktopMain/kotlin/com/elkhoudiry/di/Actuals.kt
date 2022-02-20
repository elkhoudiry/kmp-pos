package com.elkhoudiry.di

import com.elkhoudiry.domain.db.DatabaseDriverFactory
import com.elkhoudiry.pos.AppDatabase
import com.elkhoudiry.presentation.screens.checkout.CheckoutViewModel
import com.elkhoudiry.presentation.screens.menu.MenuViewModel
import com.elkhoudiry.presentation.screens.warehouses.WarehousesViewModel
import com.elkhoudiry.ui.viewmodels.CheckoutPlatformViewModel
import com.elkhoudiry.ui.viewmodels.MenuPlatformViewModel
import com.elkhoudiry.ui.viewmodels.WarehousesPlatformViewModel
import org.koin.dsl.module

actual val platformViewModelsModule = module {
    factory {
        CheckoutPlatformViewModel(CheckoutViewModel(get()))
    }

    factory {
        MenuPlatformViewModel(MenuViewModel(get()))
    }

    factory {
        WarehousesPlatformViewModel(WarehousesViewModel())
    }
}

actual val sqlDelightModule = module {

    single { DatabaseDriverFactory().createDriver() }

    single { AppDatabase(get()) }
}
