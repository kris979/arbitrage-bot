package com.agisoft.bot.kotlin

class HelloWorld {
}

fun main() {

    val ver = 2
    println("hello world " + ver)

    var l = listOf("test", "test1")
    println(l)

    var names: MutableMap<String, String> = mutableMapOf("kris" to "b")
    names.put("mathiou", "k")
    println(names)

}


