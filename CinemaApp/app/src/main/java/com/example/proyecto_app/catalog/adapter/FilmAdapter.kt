package com.example.proyecto_app.catalog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_app.R
import com.example.proyecto_app.catalog.Film
import com.example.proyecto_app.catalog.FilmProvider

class FilmAdapter(
    private val filmLista: List<Film>,
    private val onClickListener: (Film) -> Unit,
) : RecyclerView.Adapter<FilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FilmViewHolder(layoutInflater.inflate(R.layout.item_films, parent, false))
    }

    override fun getItemCount(): Int {
        return filmLista.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val item = filmLista[position]
        holder.render(item, onClickListener)

        holder.binding.cbFav.isChecked = item.favourite

        holder.binding.cbFav.setOnCheckedChangeListener { _, isChecked ->
            val film = filmLista.find { it == item }
            film?.favourite = isChecked
            if (isChecked) {
                FilmProvider.listaFavoritos.add(film!!)
                Toast.makeText(holder.itemView.context, "Añadido a favoritos", Toast.LENGTH_SHORT).show()
            } else {
                FilmProvider.listaFavoritos.remove(film!!)
                Toast.makeText(holder.itemView.context, "Quitado de favoritos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}