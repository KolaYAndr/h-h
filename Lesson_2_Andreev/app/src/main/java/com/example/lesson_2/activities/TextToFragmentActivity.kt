package com.example.lesson_2.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.lesson_2.R
import com.example.lesson_2.databinding.ActivityTextToFragmentBinding
import com.example.lesson_2.fragments.EditFragment
import com.example.lesson_2.fragments.TextFragment

class TextToFragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTextToFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextToFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    companion object{
        fun createIntent(context: Context) = Intent(context, TextToFragmentActivity::class.java)
    }
}