package com.xvadsan.blankmvvm.ui.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xvadsan.blankmvvm.data.database.DbModel
import com.xvadsan.blankmvvm.domain.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val repository: DataRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(StartState())
    val uiState = _uiState.asStateFlow()

    private var mainJob: Job? = null

    init {
        loadData()
    }

    private fun loadData() {
        mainJob?.let { if (it.isActive) return }
        mainJob = prefillData()
    }

    private fun prefillData() = viewModelScope.launch {
        repository.insertValue(DbModel(1, "Start Kuku"))

        repository.getValue(1)
            .flowOn(Dispatchers.IO)
            .onEach {
                emitState(StartEvent.Success(it))
            }
            .launchIn(viewModelScope)
    }

    private fun emitState(state: StartEvent) {
        _uiState.value = _uiState.value.applyEvent(state)
    }
}
