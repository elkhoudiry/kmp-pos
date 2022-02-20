package com.elkhoudiry.ui.destinations

import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.ui.viewmodels.WarehousesPlatformViewModel

expect fun WarehousesScreen(
    warehousesViewModel: WarehousesPlatformViewModel,
    navigationRepository: BaseNavigationRepository
)
