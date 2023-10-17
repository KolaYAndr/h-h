package com.example.lesson_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_1.databinding.ActivityFirstBinding
import java.util.TreeSet

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    private val comparator = Comparator<String> { o1, o2 -> o1.compareTo(o2) }
    private val treeSet = TreeSet(comparator)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val text = binding.editText.text.toString()
            val texts = text.split("\n")
            treeSet.addAll(texts)
        }

        binding.showButton.setOnClickListener {
            var text = ""
            treeSet.forEach {
                text += it + "\n"
            }
            binding.textView.text = text
        }
    }

    companion object {
        fun createFirstActivityIntent(context: Context) = Intent(context, FirstActivity::class.java)
    }
}