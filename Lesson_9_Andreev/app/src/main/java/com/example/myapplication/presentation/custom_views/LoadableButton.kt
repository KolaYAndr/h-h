package com.example.myapplication.presentation.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.myapplication.R
import com.example.myapplication.databinding.LoadableButtonBinding

class LoadableButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
) : FrameLayout(context, attrs) {
    private var _binding: LoadableButtonBinding? = null
    private val binding get() = _binding!!

    init {
        _binding = LoadableButtonBinding.bind(
            LayoutInflater.from(context).inflate(R.layout.loadable_button, this, true)
        )
    }

    fun clickButton(listener: () -> Unit) {
        binding.signInButton.setOnClickListener{listener()}
    }

    fun setText(text: String){
        binding.signInButton.text = text
    }

    fun setStateLoading() = binding.run {
        signInButton.text = ""
        progressBar.visibility = VISIBLE
        signInButton.isEnabled = false

    }

    fun setStateData() = binding.run {
        signInButton.text = resources.getString(R.string.sign_in_action)
        progressBar.visibility = GONE
        signInButton.isEnabled = true
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _binding = null
    }
}