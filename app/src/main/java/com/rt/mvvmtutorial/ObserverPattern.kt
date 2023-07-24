package com.rt.mvvmtutorial

import kotlin.properties.Delegates

interface IObserver {
    fun onValueChanged(value: String)
}


class ObserverPattern : IObserver {
    override fun onValueChanged(value: String) {
        println("Value Changed - $value")
    }
}
class ObserverPattern1 : IObserver {
    override fun onValueChanged(value: String) {
        println("Value1 Changed - $value")
    }
}
class ObserverClass(observer: IObserver) {
    var text: String by Delegates.observable(
        initialValue = "",
        onChange = { _, _, newValue ->
            observer.onValueChanged(newValue)
        }
    )
}

fun main() {
    var observeinstance = ObserverClass(ObserverPattern())
    var observeinstance1 = ObserverClass(ObserverPattern1())
    observeinstance.text="12334"
    observeinstance.text="12331234"
}