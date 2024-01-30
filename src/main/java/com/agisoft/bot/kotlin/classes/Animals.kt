package com.agisoft.bot.kotlin.classes

/*
 * by default, kotlin classes are final to we need to 'open' them for inheritance.
 * same with methods, in order to override them, we need to open them
 */
open class Dog {
    open fun sayHello() {
        println("woof!")
    }
}


class Yorkshire : Dog() {
    //overriding a base class method
    override fun sayHello() {
        println("wif!")
    }
}

open class Tiger(val origin: String) {
    fun hello() {
        println("A tiger from $origin says: grr!")
    }
}


class SiberianTiger : Tiger("Siberia")

//passing an argument to a base class constructor
class AfricanTiger(origin: String) : Tiger(origin = origin)

fun main() {
    val dog: Dog = Yorkshire()
    dog.sayHello()

    var tiger: Tiger = SiberianTiger()
    tiger.hello()

    tiger = AfricanTiger("Africa")
    tiger.hello()
}
