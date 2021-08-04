package com.xvadsan.blankmvvm.ui.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class Event<T>(private val content: T?) {

    companion object {
        fun<T> empty() = Event<T>(null)
    }

    private var handled = false

    fun content() = if (handled) {
        null
    } else {
        handled = true
        content
    }
}

fun <T> Flow<Event<T>>.onEachEvent(action: suspend (T) -> Unit): Flow<Event<T>> =
    onEach {
        it.content()?.let { action(it) }
    }