package com.example.lesson_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.lesson_4.databinding.ActivityMainBinding
import com.example.lesson_4.view_models.Lesson4ViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<Lesson4ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val stringObserver = Observer<String> {
            binding.textView.text = it
        }

        viewModel.stringValue.observe(this, stringObserver)

        binding.button.setOnClickListener {
            val text = binding.editText.text.toString()
            viewModel.changeStringValue(text)
        }
    }
}