package com.xvadsan.blankmvvm.ui.main

sealed class MainEvent {
    object Loading : MainEvent()
    data class Error(val exception: Exception) : MainEvent()
    object Success : MainEvent()
}

data class MainState(
    val loading: Boolean = false,
    val exception: Exception? = null,
    val success: Boolean = false,
    val event: MainEvent? = null
) {
    fun applyEvent(event: MainEvent) = when (event) {
        is MainEvent.Loading -> copy(
            loading = true,
            event = event
        )
        is MainEvent.Error -> copy(
            loading = false,
            exception = event.exception,
            event = event
        )
        is MainEvent.Success -> copy(
            success = true,
            event = event
        )
    }
}

sealed class MainNavigationState {
    object NavigationIdle : MainNavigationState()
    object NavigationSuccess : MainNavigationState()
}
