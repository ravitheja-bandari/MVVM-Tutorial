package com.rt.mvvmtutorial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CounterViewModelFactory(private var startCount: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CounterViewModel::class.java))
            return CounterViewModel(startCount) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }
}