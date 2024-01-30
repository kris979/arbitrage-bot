package com.agisoft.bot.kotlin.flow

class Ranges {
}


fun main() {
    for (i in 0..10) {
        print(i)
    }

    for (i in 0 until 5) {
        print(i)
    }

    println()

    for (i in 0 until 10 step 2) {
        print(i)
    }

    println()

    for (i in 10 downTo 0 step 2) {
        print(i)
    }

    println()

    var x = 5
    if (x in 1..5) println("x in a range from 1 to 5")
    if (x !in 6..8) println("x not in a range from 6 yo 8")
    if (x == 5) println("x is 5")


}
