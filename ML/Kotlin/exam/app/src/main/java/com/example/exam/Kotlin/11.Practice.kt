package com.example.exam.Kotlin

fun main(args:Array<String>) {

    val value : Int? = null

    when(value) {
        null -> println("value is null")
        else -> println("value is not null")
    }

    val value2: Boolean? = null
    when(value2) {
        true -> println("")
        false -> println("")
        null -> println("")
    }

    val value3  = when(value2) {
        true -> 1
        false -> 3
        null -> 2
    }

    val value4: Int = 10
    when(value4) {
        is Int -> println("value4 is int")
        else -> ("value4 is not int")
    }

    val value5: Int = 80
    when(value5) {
        in 60..70 -> println("60-70")
        in 70..80 -> println("70-80")
        in 80..90 -> println("80-90")
    }
}