package com.xvadsan.blankmvvm.ui.main

import androidx.lifecycle.ViewModel
import com.xvadsan.blankmvvm.ui.util.Event
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel constructor(
    /* no-op */
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainState())
    val uiState = _uiState.asStateFlow()

    private val _navigationState = MutableStateFlow(Event.empty<MainNavigationState>())
    val navigationState = _navigationState.asStateFlow()

    private var mainJob: Job? = null

    init {
        loadData()
    }

    private fun loadData() {
        /* no-op */
    }

    private fun emitState(state: MainEvent) {
        _uiState.value = _uiState.value.applyEvent(state)
    }

    private fun emitNavigationState(state: MainNavigationState?) {
        _navigationState.value = Event(state)
    }
}
