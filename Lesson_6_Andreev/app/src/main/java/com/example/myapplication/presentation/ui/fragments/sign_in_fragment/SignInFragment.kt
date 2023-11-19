package com.example.myapplication.presentation.ui.fragments.sign_in_fragment

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.responcemodel.ResponseStates
import com.example.myapplication.databinding.FragmentSignInBinding
import com.example.myapplication.utils.getError
import com.example.myapplication.utils.makeSnackBar
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val signInViewModel by createViewModelLazy(
        SignInViewModel::class,
        { this.viewModelStore },
        factoryProducer = { viewModelFactory }
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setErrorIcons()

        setPasswordDoOnTextChange()
        setLoginDoOnTextChange()

        setSignInViewModelObserver(view)

        binding.editTextPassword.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == EditorInfo.IME_ACTION_DONE) {
                tryLoggingIn()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

        binding.loadableButton.clickButton {
            tryLoggingIn()
        }
    }



    private fun setSignInViewModelObserver(view: View){
        signInViewModel.loginLiveData.observe(viewLifecycleOwner) { value ->
            when (value) {
                is ResponseStates.Loading -> {
                    binding.loadableButton.setStateLoading()
                }

                is ResponseStates.Failure -> {
                    value.e.let {
                        view.makeSnackBar(
                            message = it.getError() ?: "Error while getting response"
                        ).show()
                    }
                    binding.loadableButton.setStateData()
                }

                is ResponseStates.Success -> {
                    binding.loadableButton.setStateData()
                    goToCatalogScreen()
                }

                else -> {
                    binding.loadableButton.setStateData()
                    view.makeSnackBar(
                        message = "Unknown response type"
                    ).show()
                }
            }
        }
    }

    private fun tryLoggingIn() {
        val errorFlag = checkErrors() //флаг наличия хотя бы одной ошибки
        val emptinessFlag = checkEmptiness() //флаг пустоты хотя бы одного из полей ввода

        if (!errorFlag && !emptinessFlag) {
            val login = binding.editTextLogin.text.toString()
            val password = binding.editTextPassword.text.toString()
            signInViewModel.login(login, password)
        } else setErrors()
    }

    private fun goToCatalogScreen() {
        val navController = findNavController()
        navController.popBackStack(R.id.signInFragment, false)
        navController.navigate(SignInFragmentDirections.actionSignInFragmentToCatalogFragment())
    }

    private fun checkErrors() =
        !binding.layoutPassword.error.isNullOrEmpty() || !binding.layoutLogin.error.isNullOrEmpty()

    private fun checkEmptiness() =
        binding.editTextPassword.text.isNullOrEmpty() || binding.editTextLogin.text.isNullOrEmpty()

    private fun setErrorIcons() {
        binding.layoutPassword.errorIconDrawable = null
        binding.layoutLogin.errorIconDrawable = null
    }

    private fun setErrors() {
        if (binding.editTextPassword.text.isNullOrBlank()) {
            binding.layoutPassword.error =
                getString(R.string.sign_in_password_error)
        }

        if (binding.editTextLogin.text.isNullOrBlank()) {
            binding.layoutLogin.error =
                getString(R.string.sign_in_password_error)
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