package com.example.lesson_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_5.custom_view.BarChartsView
import java.util.Calendar
import java.util.Date
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<BarChartsView>(R.id.bar_charts).setData(
            mapOf(
                Pair(Calendar.getInstance().time, (0..100).random()),
                Pair(Date(2012, 12, 12), (0..100).random()),
                Pair(Date(2012, 11, 13), (0..100).random()),
                Pair(Date(2012, 10, 14), (0..100).random()),
                Pair(Date(2012, 11, 11), (0..100).random()),
                Pair(Date(2012, 11, 20), (0..100).random()),
                Pair(Date(2012, 11, 21), 0),
                Pair(Date(2012, 11, 22), 100),
                Pair(Date(2012, 11, 12), abs(System.currentTimeMillis().mod(100)))
            )
        )
    }
}