package com.example.kotlinintroduction

class Song(val titulo: String = "", val artista: String = "", val reproduciones: Int = 0, val anoLanzamiento: Int = 0) {

    val isPopular: Boolean
        get() = reproduciones >= 1000

    fun DescripcionSong() {
        println("$titulo, interpretada por $artista, se lanzó en $anoLanzamiento")
    }
}

fun main () {
    // Creamos un objeto Song
    val example = Song("Sauce Boy Freestyle 2", "Eladio Carrión", 22659614, 2020)
    // Imprimir datos de la canción
    example.DescripcionSong()
    // Calcular si la canción es popular
    println(example.isPopular)
}