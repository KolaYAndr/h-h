package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fitContentViewToInsets()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, SignInFragment())
            .commit()
    }

    private fun fitContentViewToInsets(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}