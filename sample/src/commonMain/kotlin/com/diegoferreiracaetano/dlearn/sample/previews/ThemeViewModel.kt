package com.diegoferreiracaetano.dlearn.sample.previews

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ThemeViewModel(
    darkTheme: Boolean = false
) {
    private val _isDarkTheme = MutableStateFlow(darkTheme)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme

    fun toggleTheme() {
        _isDarkTheme.value = !_isDarkTheme.value
    }
}