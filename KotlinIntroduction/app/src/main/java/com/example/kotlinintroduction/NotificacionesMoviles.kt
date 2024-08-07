package com.example.introductionkotlin

fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages<100)
        println("Tienes " + numberOfMessages + " Notificaciones")
    else
        println("¡Tu teléfono está explotando! Tienes más de 99 notificaciones.")
}