package com.xvadsan.blankmvvm.ui.start

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun StartScreen(
    viewModel: StartViewModel = hiltViewModel()
) {

    val startState: State<StartState?> = viewModel.uiState.collectAsState()
    val text = startState.value?.success?.name ?: "0"

    Scaffold {
        Text(text = text, modifier = Modifier.padding(24.dp))
    }
}

