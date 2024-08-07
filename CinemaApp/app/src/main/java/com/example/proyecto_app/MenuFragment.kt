package com.example.proyecto_app

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.proyecto_app.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.main_menu_title)

        mostrarMensaje()

        val btnCatalog = binding.btnCatalog
        btnCatalog.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToItemListFragment()
            findNavController().navigate(action)
        }

        binding.tvWelcome.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_silkscreen_regular)
        binding.btnCatalog.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_silkscreen_regular)
        binding.btnCollection.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_silkscreen_regular)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.options_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.settings_menu -> {
                        findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToCreditFragment())
                        true
                    }
                    R.id.userInfo_menu -> {
                        findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToUserInfoFragment())
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mostrarMensaje() {
        val tvWelcomeBinding = binding.tvWelcome
        val user = obtenerUsuario()

        // Se crea el string personalizado para el mensaje de bienvenida
        val WelcomeMessageTemplate = resources.getString(R.string.msg_menu_welcome)
        tvWelcomeBinding.text = String.format(WelcomeMessageTemplate, user)
    }

    private fun obtenerUsuario(): String {
        val sharedPreferences = requireActivity().getSharedPreferences("PREFS", Context.MODE_PRIVATE)
        return sharedPreferences.getString("user", "Guest") ?: "Guest"
    }

}