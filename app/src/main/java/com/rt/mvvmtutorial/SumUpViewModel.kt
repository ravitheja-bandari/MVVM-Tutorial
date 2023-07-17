package com.rt.mvvmtutorial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SumUpViewModel(startNumber: Int) : ViewModel() {

    var sum = MutableLiveData<Int>()

    init {
        sum.value = startNumber
    }

    fun addInput(input: Int) {
        sum.value = (sum.value)?.plus(input)
    }

}