package com.example.introductionkotlin

fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("El precio de un entrada de cine para una persona de $child es \$${ticketPrice(child, isMonday)}.")
    println("El precio de un entrada de cine para una persona de $adult es \$${ticketPrice(adult, isMonday)}.")
    println("El precio de un entrada de cine para una persona de $senior es \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when {
        age in 1..12 -> 15
        age in 13..60 -> 30
        age in 61..100 -> 20
        age in 13..60 && isMonday == true -> 25
        else -> -1
    }
}