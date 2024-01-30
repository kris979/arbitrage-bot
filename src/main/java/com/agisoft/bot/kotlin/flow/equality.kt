package com.agisoft.bot.kotlin.flow

fun main() {
    //Kotlin uses == for structural comparison and === for referential comparison.
    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    println(authors == writers)
    println(authors === writers)
}
