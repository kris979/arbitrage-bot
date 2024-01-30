package com.agisoft.bot.kotlin.flow

fun max(a: Int, b: Int): Int {
    if (a > b)
        return a
    else
        return b
}

//There is no ternary operator condition ? then : else in Kotlin. Instead, if may be used as an expression:
fun max2(a: Int, b: Int) = if (a > b) a else b

fun main() {
    //Kotlin uses == for structural comparison and === for referential comparison.
    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    println(authors == writers)
    println(authors === writers)

    println(max(99, -42))
}
