package com.agisoft.bot.kotlin

open class Contact (val id: Int, var email: String) {
    var category: String = ""

    fun printCategory() {
        println(category)
    }

    override fun toString(): String {
        return "Contact(id=$id, email='$email', category='$category')"
    }
}

class MsgContact (id: Int, email: String) : Contact(id = id, email = email) {
    fun message(msg: String, prefix: String = "Info") {
        println("[$prefix]: $msg")
    }

    fun messages(vararg msgs: String) {
        for (m in msgs) {
            print("$m, ")
        }
    }
}

fun main() {
    val contact = MsgContact(1,"kris@gmail.com")
    contact.category = "family"
    println(contact)
    println(contact.category)
    println(contact.email)
    contact.email = "goto@hell.com"
    println(contact)
    contact.printCategory()
    contact.message("This a standard log msg.")
    contact.message("I am warning you.", "Warning")
    contact.messages("msg1", "msg2", "msg3")
}
