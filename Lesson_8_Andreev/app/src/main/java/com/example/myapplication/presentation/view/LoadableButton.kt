package com.example.myapplication.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.myapplication.R
import com.example.myapplication.databinding.LoadableButtonBinding

class LoadableButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
) : FrameLayout(context, attrs) {
    private var binding: LoadableButtonBinding? = null

    init {
        binding = LoadableButtonBinding.bind(
            LayoutInflater.from(context).inflate(R.layout.loadable_button, this, true)
        )
    }

    fun clickButton(listener: () -> Unit) {
        binding!!.signInButton.setOnClickListener{listener()}
    }

    fun setStateLoading() = binding?.run {
        signInButton.text = ""
        progressBar.visibility = VISIBLE
        signInButton.isEnabled = false

    }

    fun setStateData() = binding?.run {
        signInButton.text = resources.getString(R.string.sign_in_action)
        progressBar.visibility = GONE
        signInButton.isEnabled = true
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        binding = null
    }
}