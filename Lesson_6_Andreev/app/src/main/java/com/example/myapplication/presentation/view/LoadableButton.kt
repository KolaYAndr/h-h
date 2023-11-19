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

    fun setStateLoading() = binding?.run {
        this.signInButton.text = ""
        this.progressBar.visibility = VISIBLE
    }

    fun setStateData() = binding?.run {
        this.signInButton.text = resources.getString(R.string.sign_in_action)
        this.progressBar.visibility = GONE
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        binding = null
    }
}