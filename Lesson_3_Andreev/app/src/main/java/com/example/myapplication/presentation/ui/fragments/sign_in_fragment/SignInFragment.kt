package com.example.myapplication.presentation.ui.fragments.sign_in_fragment

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
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
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToCatalogFragment())
        }

        binding.editTextPassword.doAfterTextChanged {
            if (it.isNullOrBlank()) binding.layoutPassword.error =
                getString(R.string.sign_in_password_error)
            else binding.layoutPassword.error = null
        }

        binding.editTextLogin.doAfterTextChanged {
            if (it.isNullOrEmpty() || !Patterns.EMAIL_ADDRESS.matcher(it)
                    .matches()
            ) binding.layoutLogin.error = getString(R.string.sign_in_login_error)
            else binding.layoutLogin.error = null
        }
    }
}