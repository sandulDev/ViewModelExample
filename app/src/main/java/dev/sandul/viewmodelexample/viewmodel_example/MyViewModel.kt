package dev.sandul.viewmodelexample.viewmodel_example

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyViewModel : ViewModel() {
    private val _counter = MutableStateFlow<Int>(0)
    val counter = _counter.asStateFlow()

    fun increment() {
        _counter.value++
    }
}