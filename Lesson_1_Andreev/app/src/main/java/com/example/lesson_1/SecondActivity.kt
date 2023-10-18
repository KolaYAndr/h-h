package com.example.lesson_1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson_1.databinding.ActivitySecondBinding
import java.util.TreeSet

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val studentComparator =
        Comparator<Student> { o1, o2 -> o1.surname.compareTo(o2.surname) }
    private val studentTreeSet = TreeSet(studentComparator)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editText.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val texts = binding.editText.text.toString().split("\n")
                texts.forEach {
                    val data = it.split(" ")
                    val student = Student(
                        name = data[0],
                        surname = data[1],
                        grade = data[2],
                        birthdayYear = data[3].toInt()
                    )
                    studentTreeSet.add(student)
                }
                return@setOnKeyListener true
            }
            false
        }

        binding.showButton.setOnClickListener {
            var text = ""
            studentTreeSet.forEach {
                text += "Id: ${it.id}, name: ${it.name}, surname: ${it.surname}, grade: ${it.grade}, birthday year: ${it.birthdayYear}\n"
            }
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

            binding.textView.text = text
        }
    }


    companion object {
        fun createSecondActivityIntent(context: Context) =
            Intent(context, SecondActivity::class.java)
    }
}