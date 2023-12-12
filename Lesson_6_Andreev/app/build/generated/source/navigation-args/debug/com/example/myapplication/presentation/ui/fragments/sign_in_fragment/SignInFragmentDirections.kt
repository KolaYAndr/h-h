package com.example.myapplication.presentation.ui.fragments.sign_in_fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.myapplication.R

public class SignInFragmentDirections private constructor() {
  public companion object {
    public fun actionSignInFragmentToCatalogFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_signInFragment_to_catalogFragment)
  }
}
