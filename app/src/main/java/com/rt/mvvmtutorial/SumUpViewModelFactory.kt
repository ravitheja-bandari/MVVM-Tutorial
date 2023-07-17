package com.rt.mvvmtutorial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SumUpViewModelFactory(private var startingNumber: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SumUpViewModel::class.java))
            return SumUpViewModel(startingNumber) as T
        throw IllegalArgumentException("UnKnown ViewModel")
    }
}