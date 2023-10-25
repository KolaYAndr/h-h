package com.example.lesson_2.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.lesson_2.R
import com.example.lesson_2.databinding.ActivityLoggedBinding
import com.example.lesson_2.fragments.EmptyFragment

class LoggedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoggedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoggedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(R.id.fragment_container_view0)
        showFragment(R.id.fragment_container_view1)
    }

    private fun showFragment(@IdRes id: Int){
        supportFragmentManager.beginTransaction()
            .add(id, EmptyFragment())
            .commit()
    }

    companion object{
        fun createIntent(context: Context) = Intent(context, LoggedActivity::class.java)
    }
}