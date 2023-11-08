package com.example.lesson_2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goToThreeFragmentActivity.setOnClickListener {
            val threeFragmentsActivityIntent = ThreeFragmentsActivity.createIntent(this)
            startActivity(threeFragmentsActivityIntent)
        }

        binding.goTextToAnotherFragmentActivity.setOnClickListener {
            val textToAnotherFragmentIntent = TextToFragmentActivity.createIntent(this)
            startActivity(textToAnotherFragmentIntent)
        }

        binding.goLoggedActivity.setOnClickListener {
            val loggedIntent = LoggedActivity.createIntent(this)
            startActivity(loggedIntent)
        }
    }
}