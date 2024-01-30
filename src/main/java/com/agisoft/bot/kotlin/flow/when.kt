package com.agisoft.bot.kotlin.flow

//when is like a java switch
fun cases(obj: Any) {
    when (obj) {
        1 -> println("one")
        "Hello" -> println("greetings")
    }
}

fun cakes(cakes: List<String>) {
    println("We have got  ${cakes.size} cakes.")
    for (cake in cakes) {
        println(cake)
    }
}


fun main() {
    cases(1)
    cases("Hello")
    cakes(listOf("carrot", "cheese", "cherry"))
}
