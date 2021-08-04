package com.xvadsan.blankmvvm

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupOutsideLibs()
    }

    private fun setupOutsideLibs() {
        AndroidThreeTen.init(this)
    }

}