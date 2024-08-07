package com.example.proyecto_app.catalog

class FilmProvider {
    companion object {
        val listaFilms = mutableListOf<Film>(
            Film("A1","Migración", "2023", "Illumination Entertainment", "La familia Mallard se ha quedado 'estancada'. Mientras papá Mack se siente realizado cuidando de su familia en su estanque...", "", "https://pics.filmaffinity.com/migration-919147712-large.jpg", false),
            Film("A2","Super Mario Bros", "2023", "Illumination Entertainment", "Mientras trabajan en una avería subterránea, los fontaneros de Brooklyn, Mario y su hermano Luigi, viajan por una misteriosa tubería...", "","https://pics.filmaffinity.com/the_super_mario_bros_movie-521125124-large.jpg", false),
            Film("A3","Gru 4 Mi villano favorito", "2024", "Illumination Entertainment", "Gru y Lucy están casados y luchan junto a su familia en la llamada Liga Antivillanos... ", "","https://pics.filmaffinity.com/despicable_me_4-550025219-large.jpg", false),
            Film("A4","Spider-Man: Un nuevo universo", "2018", "Sony Pictures Animation", "En un universo paralelo donde Peter Parker ha muerto, un joven de secundaria llamado Miles Morales es el nuevo Spider-Man... ","","https://m.media-amazon.com/images/I/91UCSaRIgmL._AC_UF894,1000_QL80_.jpg", false),
            Film("A5","Spider-Man: Cruzando el Multiverso", "2023", "Sony Pictures Animation","Tras reencontrarse con Gwen Stacy, el amigable vecindario de Spider-Man de Brooklyn al completo es catapultado a través del Multiverso...", "","https://pics.filmaffinity.com/spider_man_across_the_spider_verse-257260163-large.jpg", false),
            Film("A6","Dragon Ball Super: Broly", "2018", "Toei Animation","La Tierra disfruta en paz la celebración de el Torneo del Poder. Sin embargo, Goku es consciente de que existen enemigos...", "","https://pics.filmaffinity.com/doragon_boru_cho_burori-949664812-large.jpg", false),
        )

        val listaFavoritos = mutableListOf<Film>(
            // Monedas favoritas se guardan aquí
        )
    }
}