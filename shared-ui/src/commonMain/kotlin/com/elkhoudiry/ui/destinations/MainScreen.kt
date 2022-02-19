package com.elkhoudiry.ui.destinations

import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.ui.helpers.ResContext

expect fun MainScreen(
    navigationRepository: BaseNavigationRepository
)