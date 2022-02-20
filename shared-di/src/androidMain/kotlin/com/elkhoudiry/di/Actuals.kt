package com.elkhoudiry.di

import com.elkhoudiry.presentation.screens.checkout.CheckoutViewModel
import com.elkhoudiry.presentation.screens.menu.MenuViewModel
import com.elkhoudiry.presentation.screens.warehouses.WarehousesViewModel
import com.elkhoudiry.ui.viewmodels.CheckoutPlatformViewModel
import com.elkhoudiry.ui.viewmodels.MenuPlatformViewModel
import com.elkhoudiry.ui.viewmodels.WarehousesPlatformViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

actual val platformViewModelsModule = module {
    viewModel {
        CheckoutPlatformViewModel(CheckoutViewModel(get()))
    }

    viewModel {
        MenuPlatformViewModel(MenuViewModel(get()))
    }

    viewModel {
        WarehousesPlatformViewModel(WarehousesViewModel())
    }
}
