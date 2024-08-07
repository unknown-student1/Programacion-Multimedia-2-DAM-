package com.example.proyecto_app.catalog.favItemList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_app.R
import com.example.proyecto_app.catalog.Film
import com.example.proyecto_app.catalog.FilmProvider
import com.example.proyecto_app.catalog.adapter.FilmAdapter
import com.example.proyecto_app.databinding.FragmentFavItemListBinding


class FavItemListFragment : Fragment() {

    private var _binding: FragmentFavItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.fav_item_list_title)

        iniciarRecyclerViewVert()

        binding.tvFavItemListTittle.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_silkscreen_regular)
    }

    fun iniciarRecyclerViewVert() {
        val manager = LinearLayoutManager(requireContext())
        binding.RVFavFilms.layoutManager = manager
        binding.RVFavFilms.adapter = FilmAdapter(
            FilmProvider.listaFavoritos,
            { film -> onItemSelected(film) },
        )
    }

    private fun onItemSelected(film: Film) {
        val action = FavItemListFragmentDirections.actionFavItemListFragmentToFavDetailItemFragment(film.id)
        findNavController().navigate(action)
    }
}