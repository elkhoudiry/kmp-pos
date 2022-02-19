package com.elkhoudiry.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elkhoudiry.presentation.screens.menu.MenuEvent
import com.elkhoudiry.presentation.screens.menu.MenuViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

actual class MenuPlatformViewModel(
    private val viewModel: MenuViewModel
): ViewModel() {

    fun getState() = viewModel.state

    fun onEvent(event: MenuEvent) {
        viewModelScope.launch { viewModel.onEvent(event) }
    }
}

