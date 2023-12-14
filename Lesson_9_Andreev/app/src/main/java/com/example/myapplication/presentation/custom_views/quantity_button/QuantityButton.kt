package com.example.myapplication.presentation.custom_views.quantity_button

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.myapplication.R
import com.example.myapplication.databinding.QuantityButtonBinding

class QuantityButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
) : LinearLayout(context, attrs) {
    private var _binding: QuantityButtonBinding? = null
    private val binding get() = _binding!!

    init {
        _binding = QuantityButtonBinding.bind(
            LayoutInflater.from(context).inflate(R.layout.quantity_button, this, true)
        )
    }

    fun setDecreaseButtonDisabled() {
        binding.quantityButtonDecrease.isEnabled = false
    }

    fun setDecreaseButtonEnabled() {
        binding.quantityButtonDecrease.isEnabled = true
    }

    fun setDecreaseButtonClickListener(listener: OnClickListener) {
        binding.quantityButtonDecrease.setOnClickListener(listener)
    }

    fun setIncreaseButtonClickListener(listener: OnClickListener) {
        binding.quantityButtonIncrease.setOnClickListener(listener)
    }

    fun setText(text: Int) {
        binding.quantityButtonText.text = text.toString()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _binding = null
    }
}