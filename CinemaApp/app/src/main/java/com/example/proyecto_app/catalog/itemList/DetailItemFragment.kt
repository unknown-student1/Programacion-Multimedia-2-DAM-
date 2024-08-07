package com.example.proyecto_app.catalog.itemList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.proyecto_app.R
import com.example.proyecto_app.catalog.FilmProvider
import com.example.proyecto_app.databinding.FragmentDetailItemBinding

class DetailItemFragment : Fragment() {

    private var _binding: FragmentDetailItemBinding? = null
    private val binding get() = _binding!!

    private val args: DetailItemFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.detail_item_list_title)

        rellenarDetalles(args.filmId)

    }

    fun rellenarDetalles(filmId: String) {
    // Encuentra la moneda en la lista de monedas
    val film = FilmProvider.listaFilms.find { it.id == filmId }

    // Si la moneda existe, llena los campos de texto y la imagen con los datos de la moneda
    film?.let {
        Glide.with(this)
            .load(it.imagen)
            .into(binding.ivImagen)
        binding.tvFilmTitle.text = it.titulo
        binding.tvFilmCompany.text = it.estudio
        binding.tvFilmYear.text = it.anno
        binding.tvFilmSinopsis.text = it.sinopsis
        binding.cbFav.isChecked = it.favourite

        binding.cbFav.setOnCheckedChangeListener { _, isChecked ->
            it.favourite = isChecked

            if (isChecked) {
                FilmProvider.listaFavoritos.add(film!!)
                Toast.makeText(this.context, "Añadido a favoritos", Toast.LENGTH_SHORT).show()
            } else {
                FilmProvider.listaFavoritos.remove(film!!)
                Toast.makeText(this.context, "Quitado de favoritos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    }
}
