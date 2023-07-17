package com.rt.mvvmtutorial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {
    var _startCount = 0
    constructor(startCount: Int) : this() {
        _startCount = startCount
    }

    var counter = 0

    init {
        counter = _startCount
    }

    fun getCurrentCounter(): Int {
        return counter
    }

    fun getUpdatedCounter(): Int {
        return ++counter
    }

     var count = MutableLiveData<Int>()

    init {
        count.value=0
    }

    fun updateCounter(){
        count.value = (count.value)?.plus(1)
    }


}