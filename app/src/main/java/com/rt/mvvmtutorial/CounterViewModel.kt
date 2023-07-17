package com.rt.mvvmtutorial

import androidx.lifecycle.ViewModel

class CounterViewModel(startCount: Int) : ViewModel() {

    private var counter = 0

    init {
        counter = startCount
    }

    fun getCurrentCounter(): Int {
        return counter
    }

    fun getUpdatedCounter(): Int {
        return ++counter
    }
}