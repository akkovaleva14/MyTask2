package com.example.mytask2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/* Класс SharedViewModel: ViewModel, который управляет состоянием кликов.
MutableStateFlow: Используется для хранения и управления состоянием количества кликов.
Это позволяет фрагментам подписываться на изменения.*/
class SharedViewModel : ViewModel() {

    private val _clickCount = MutableStateFlow(0)
    val clickCount: Flow<Int> = _clickCount

    fun incrementCount() {
        _clickCount.value++
    }
}