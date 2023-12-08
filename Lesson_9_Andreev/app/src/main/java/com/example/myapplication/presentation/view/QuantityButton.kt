package com.example.myapplication.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.myapplication.R
import com.example.myapplication.databinding.QuantityButtonBinding

class QuantityButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
) : LinearLayout(context, attrs) {
    private var binding: QuantityButtonBinding? = null

    init {
        binding = QuantityButtonBinding.bind(
            LayoutInflater.from(context).inflate(R.layout.quantity_button, this, true)
        )
    }

    fun setDecreaseButtonClickListener(listener: OnClickListener) {
        binding!!.quantityButtonDecrease.setOnClickListener(listener)
    }

    fun setIncreaseButtonClickListener(listener: OnClickListener) {
        binding!!.quantityButtonIncrease.setOnClickListener(listener)
    }

    fun setText(text: Int){
        binding!!.quantityButtonText.text = text.toString()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        binding = null
    }
}