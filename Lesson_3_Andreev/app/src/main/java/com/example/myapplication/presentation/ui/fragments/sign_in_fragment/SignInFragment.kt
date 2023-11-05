package com.example.myapplication.presentation.ui.fragments.sign_in_fragment

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInButton.setOnClickListener {
            //флаг наличия хотя бы одной ошибки
            val errorFlag =
                !binding.layoutPassword.error.isNullOrEmpty() || !binding.layoutLogin.error.isNullOrEmpty()
            //флаг пустоты хотя бы одного из полей ввода
            val emptinessFlag =
                binding.editTextPassword.text.isNullOrEmpty() || binding.editTextLogin.text.isNullOrEmpty()
            if (!errorFlag && !emptinessFlag)
                findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToCatalogFragment())

            if (binding.editTextPassword.text.isNullOrBlank()) binding.layoutPassword.error =
                getString(R.string.sign_in_password_error)

            if (binding.editTextLogin.text.isNullOrBlank()) binding.layoutLogin.error =
                getString(R.string.sign_in_password_error)
        }

        binding.editTextPassword.doOnTextChanged { text, _, _, _ ->
            if (text.isNullOrBlank()) binding.layoutPassword.error =
                getString(R.string.sign_in_password_error)
            else binding.layoutPassword.error = null
        }

        binding.editTextLogin.doOnTextChanged { text, _, _, _ ->
            if (text.isNullOrEmpty() || !Patterns.EMAIL_ADDRESS.matcher(text)
                    .matches()
            ) binding.layoutLogin.error = getString(R.string.sign_in_login_error)
            else binding.layoutLogin.error = null
        }
    }
}