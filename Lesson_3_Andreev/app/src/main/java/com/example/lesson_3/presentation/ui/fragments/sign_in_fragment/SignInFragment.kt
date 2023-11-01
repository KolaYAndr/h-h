package com.example.lesson_3.presentation.ui.fragments.sign_in_fragment

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.lesson_3.R
import com.example.lesson_3.databinding.FragmentSignInBinding

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.signInButton.setOnClickListener {
            Log.d("check out", "ok")
        }

        binding.editTextPassword.doOnTextChanged { text, _, _, _ ->
            if (text.isNullOrEmpty()){
                binding.layoutPassword.error = getString(R.string.sign_in_password_error)
            }else{
                binding.layoutLogin.error = null
            }
        }

        binding.editTextLogin.doOnTextChanged { text, _, _, _ ->
            if (text.isNullOrEmpty() || !Patterns.EMAIL_ADDRESS.matcher(text).matches()){
                binding.layoutLogin.error = getString(R.string.sign_in_login_error)
            }else{
                binding.layoutLogin.error = null
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}