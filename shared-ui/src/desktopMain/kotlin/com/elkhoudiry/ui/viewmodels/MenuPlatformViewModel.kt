package com.elkhoudiry.ui.viewmodels

import com.elkhoudiry.presentation.screens.menu.MenuEvent
import com.elkhoudiry.presentation.screens.menu.MenuViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

actual class MenuPlatformViewModel(
    private val viewModel: MenuViewModel
) {
    private val scope = CoroutineScope(Dispatchers.Default)

    fun getState() = viewModel.state

    fun onEvent(event: MenuEvent) {
        scope.launch { viewModel.onEvent(event) }
    }
}
