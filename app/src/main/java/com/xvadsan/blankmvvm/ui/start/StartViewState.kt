package com.xvadsan.blankmvvm.ui.start

import com.xvadsan.blankmvvm.data.database.DbModel

sealed class StartEvent {
    object Loading : StartEvent()
    data class Error(val exception: Exception) : StartEvent()
    data class Success(val dbModel: DbModel) : StartEvent()
}

data class StartState(
    val loading: Boolean = false,
    val exception: Exception? = null,
    val success: DbModel? = null,
    val event: StartEvent? = null
) {
    fun applyEvent(event: StartEvent) = when (event) {
        is StartEvent.Loading -> copy(
            loading = true,
            event = event
        )
        is StartEvent.Error -> copy(
            loading = false,
            exception = event.exception,
            event = event
        )
        is StartEvent.Success -> copy(
            success = event.dbModel,
            event = event
        )
    }
}
