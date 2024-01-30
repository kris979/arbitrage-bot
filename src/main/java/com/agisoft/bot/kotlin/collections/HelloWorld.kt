package com.agisoft.bot.kotlin.collections

fun main() {

    val ver = 2
    println("hello world $ver")

    val l = listOf("test", "test1")
    println(l)

    val names: MutableMap<String, String> = mutableMapOf("kris" to "b")
    names["mathiou"] = "k"
    println(names)

}


