package com.example.lesson_2.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lesson_2.R
import com.example.lesson_2.databinding.ActivityThreeFragmentsBinding
import com.example.lesson_2.fragments.FirstFragment
import com.example.lesson_2.fragments.SecondFragment
import com.example.lesson_2.fragments.ThirdFragment

class ThreeFragmentsActivity: AppCompatActivity() {
    private val thirdFragment = ThirdFragment()
    private val secondFragment = SecondFragment()
    private val firstFragment = FirstFragment()

    private lateinit var binding: ActivityThreeFragmentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goFirst.setOnClickListener {
            showFragment(firstFragment)
        }

        binding.goSecond.setOnClickListener {
            showFragment(secondFragment)
        }

        binding.goThird.setOnClickListener {
            showFragment(thirdFragment)
        }
    }

    private fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_view, fragment)
            .commitNow()
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ThreeFragmentsActivity::class.java)
    }
}