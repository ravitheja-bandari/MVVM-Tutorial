package com.rt.mvvmtutorial


object SingletonOne {
    fun doSomething() = println("Do Something")
}

class SingletonTwo private constructor() {

    companion object {

        @Volatile
        private var instance: SingletonTwo? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: SingletonTwo().also { instance = it }
            }
    }

    fun doSomething() = println("Do Something")
}

class SingletonThree private constructor() {
    companion object {
        val instance: SingletonThree by lazy {
            SingletonThree()
        }
    }
    fun doSomething() = println("Do Something")
}


fun main() {

    SingletonOne.doSomething()

    SingletonTwo.getInstance().doSomething()

    SingletonThree.instance.doSomething()

}