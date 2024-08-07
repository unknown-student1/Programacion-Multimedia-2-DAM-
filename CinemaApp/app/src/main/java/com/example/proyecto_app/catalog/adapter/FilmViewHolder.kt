package com.example.proyecto_app.catalog.adapter

import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_app.catalog.Film
import com.bumptech.glide.Glide
import com.example.proyecto_app.R
import com.example.proyecto_app.databinding.ItemFilmsBinding


class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemFilmsBinding.bind(view)

    fun render(filmModel: Film, onClickListener: (Film) -> Unit){

        binding.tvFilmTitle.text = filmModel.titulo
        binding.tvFilmYear.text = filmModel.anno
        binding.tvFilmCompany.text = filmModel.estudio
        Glide.with(binding.ivImagen.context).load(filmModel.imagen).into(binding.ivImagen)

        binding.root.setOnClickListener { onClickListener(filmModel) }
    }
}