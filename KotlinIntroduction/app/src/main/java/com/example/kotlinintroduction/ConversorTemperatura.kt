package com.example.kotlinintroduction

fun main() {
    // Fill in the code.
    printFinalTemperature(35.2,"Celsius","Fahrenheit") {it * 9/5 + 32}
    printFinalTemperature(308.35, "Kelvin", "Celsius") {it - 273.15}
    printFinalTemperature(95.36, "Fahrenheit", "Kelvin") {(it-32) * 5/9 + 273.15}
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}




