package com.xvadsan.blankmvvm.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xvadsan.blankmvvm.domain.DataRepository
import com.xvadsan.blankmvvm.data.database.DbModel
import com.xvadsan.blankmvvm.ui.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: DataRepository
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
        mainJob?.let { if (it.isActive) return }
        mainJob = prefillData()
    }

    private fun prefillData() = viewModelScope.launch {
        repository.insertValue(DbModel(1, "Rukallo"))

        repository.getValue(1)
            .flowOn(Dispatchers.IO)
            .onEach {
                emitState(MainEvent.Success(it))
            }
            .launchIn(viewModelScope)
    }

    private fun emitState(state: MainEvent) {
        _uiState.value = _uiState.value.applyEvent(state)
    }

    private fun emitNavigationState(state: MainNavigationState?) {
        _navigationState.value = Event(state)
    }
}
