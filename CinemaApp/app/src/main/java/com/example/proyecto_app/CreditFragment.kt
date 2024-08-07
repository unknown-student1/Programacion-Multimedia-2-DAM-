package com.example.proyecto_app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.LocaleListCompat
import androidx.navigation.fragment.findNavController
import com.example.proyecto_app.databinding.FragmentCreditBinding


class CreditFragment : Fragment() {

    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.credit_title)

        nightMode()
        languageMode()

        val btnReturn = binding.btnReturn
        btnReturn.setOnClickListener {
            val action = CreditFragmentDirections.actionCreditFragmentToMenuFragment()
            findNavController().navigate(action)
        }

        val btnContactar = binding.btnContactar;
        // Añadir funcionalidad al botón de contactar
        btnContactar.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "plain/text"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("correocontacto@2cinema.es"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app ${getString(R.string.app_name)}")

            // Comprobar si hay aplicaciones que puedan manejar el Intent
            if (emailIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(emailIntent)
            } else {
                Toast.makeText(requireContext(), "No hay aplicaciones de correo electrónico instaladas", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvCreditTittle.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_silkscreen_regular)
        binding.tvLanguajeEN.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_silkscreen_regular)
        binding.tvLanguajeES.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_silkscreen_regular)
        binding.btnReturn.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_silkscreen_regular)
        binding.btnContactar.typeface = ResourcesCompat.getFont(requireContext(), R.font.font_silkscreen_regular)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun nightMode() {
        val modeSwitch = binding.switchDarkMode

        val sharedPreferences = activity?.getSharedPreferences("MODE", Context.MODE_PRIVATE)
        val nightMode = sharedPreferences?.getBoolean("NIGHT_MODE", false)!!

        // Verifica el modo actual de la aplicación e inicializa el interruptor en la posición correspondiente
        modeSwitch.isChecked = nightMode

        modeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

            // Guarda la preferencia para futuros usos
            with(sharedPreferences?.edit()) {
                this?.putBoolean("NIGHT_MODE", isChecked)
                this?.apply()
            }
        }
    }

    private fun languageMode() {
        val languageSwitch = binding.switchLanguaje

        val sharedPreferences = activity?.getSharedPreferences("MODE", Context.MODE_PRIVATE)
        val languagePreference = sharedPreferences?.getString("LANGUAGE", "en-EN")

        // Verifica el idioma actual de la aplicación e inicializa el interruptor en la posición correspondiente
        languageSwitch.isChecked = languagePreference == "es-ES"

        languageSwitch.setOnCheckedChangeListener { _, isChecked ->
            val newLanguage = if (isChecked) "es-ES" else "en-EN"

            // Actualiza el idioma de la aplicación
            val appLocale: LocaleListCompat =
                LocaleListCompat.forLanguageTags(newLanguage)
            AppCompatDelegate.setApplicationLocales(appLocale)

            // Guarda la preferencia para futuros usos
            with(sharedPreferences?.edit()) {
                this?.putString("LANGUAGE", newLanguage)
                this?.apply()
            }

        }
    }
}