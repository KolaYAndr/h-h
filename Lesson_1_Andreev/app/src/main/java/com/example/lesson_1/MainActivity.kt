package com.example.lesson_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson_1.FirstActivity.Companion.createFirstActivityIntent
import com.example.lesson_1.SecondActivity.Companion.createSecondActivityIntent
import com.example.lesson_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startActivity1.setOnClickListener {
            val intent = createFirstActivityIntent(this)
            startActivity(intent)
        }

        binding.startActivity2.setOnClickListener {
            val intent = createSecondActivityIntent(this)
            startActivity(intent)
        }
    }
}

