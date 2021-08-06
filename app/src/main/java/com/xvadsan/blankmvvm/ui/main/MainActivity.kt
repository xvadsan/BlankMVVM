package com.xvadsan.blankmvvm.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.xvadsan.blankmvvm.ui.start.StartScreen
import com.xvadsan.blankmvvm.ui.start.StartViewModel
import com.xvadsan.blankmvvm.ui.theme.BlankMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val model: StartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlankMVVMTheme {
                StartScreen(model)
            }
        }
    }
}
