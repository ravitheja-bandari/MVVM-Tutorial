package com.rt.mvvmtutorial

import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {

    private var counter = 0

    fun getCurrentCounter(): Int {
        return counter
    }

    fun getUpdatedCounter(): Int {
        return ++counter
    }
}