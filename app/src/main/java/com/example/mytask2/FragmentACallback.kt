package com.example.mytask2

/* Интерфейс FragmentACallback: Определяет метод sendDataToFragmentB,
который используется для передачи данных из FragmentA в FragmentB. */
interface FragmentACallback {
    fun sendDataToFragmentB(data: String)
}