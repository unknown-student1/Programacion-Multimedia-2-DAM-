package com.example.proyecto_app.catalog

data class Film(
    val id: String,
    val titulo: String,
    val anno: String,
    val estudio: String,
    val sinopsis: String,
    var comentarios: String,
    val imagen: String,
    var favourite: Boolean
)
