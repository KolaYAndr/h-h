package com.example.myapplication.presentation.ui.fragments.sign_in_fragment

import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
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

        binding.signInButton.setOnClickListener { goToCatalogScreen() }

        binding.editTextPassword.setOnKeyListener { _, keyCode, event ->
            goToCatalogScreen(keyCode, event)
        }

        setPasswordDoOnTextChange()

        setLoginDoOnTextChange()
    }

    private fun goToCatalogScreen() {
        //флаг наличия хотя бы одной ошибки
        val errorFlag = checkErrors()
        //флаг пустоты хотя бы одного из полей ввода
        val emptinessFlag = checkEmptiness()
        if (!errorFlag && !emptinessFlag)
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToCatalogFragment())
        setErrors()
    }

    private fun goToCatalogScreen(keyCode: Int, event: KeyEvent): Boolean {
        if (event.action == KeyEvent.ACTION_DOWN && keyCode == EditorInfo.IME_ACTION_DONE) {
            //флаг наличия хотя бы одной ошибки
            val errorFlag = checkErrors()
            //флаг пустоты хотя бы одного из полей ввода
            val emptinessFlag = checkEmptiness()
            if (!errorFlag && !emptinessFlag) {
                findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToCatalogFragment())
                return true
            }
        }
        setErrors()
        return false
    }

    private fun checkErrors() =
        !binding.layoutPassword.error.isNullOrEmpty() || !binding.layoutLogin.error.isNullOrEmpty()

    private fun checkEmptiness() =
        binding.editTextPassword.text.isNullOrEmpty() || binding.editTextLogin.text.isNullOrEmpty()

    private fun setErrors() {
        if (binding.editTextPassword.text.isNullOrBlank()) {
            binding.layoutPassword.error =
                getString(R.string.sign_in_password_error)
            binding.layoutPassword.errorIconDrawable = null
        }

        if (binding.editTextLogin.text.isNullOrBlank()) {
            binding.layoutLogin.error =
                getString(R.string.sign_in_password_error)
            binding.layoutLogin.errorIconDrawable = null
        }
    }

    private fun setPasswordDoOnTextChange() {
        binding.editTextPassword.doOnTextChanged { text, _, _, _ ->
            if (text.isNullOrBlank()) {
                binding.layoutPassword.error =
                    getString(R.string.sign_in_password_error)
                binding.layoutPassword.errorIconDrawable = null
            } else binding.layoutPassword.error = null
        }
    }

    private fun setLoginDoOnTextChange() {
        binding.editTextLogin.doOnTextChanged { text, _, _, _ ->
            if (text.isNullOrEmpty() || !Patterns.EMAIL_ADDRESS.matcher(text)
                    .matches()
            ) {
                binding.layoutLogin.error = getString(R.string.sign_in_login_error)
                binding.layoutLogin.errorIconDrawable = null
            } else binding.layoutLogin.error = null
        }
    }
}