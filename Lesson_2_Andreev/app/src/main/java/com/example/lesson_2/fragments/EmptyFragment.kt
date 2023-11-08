package com.example.lesson_2.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson_2.R
class EmptyFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment " + this.hashCode(), "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Fragment " + this.hashCode(), "onCreateView")
        return inflater.inflate(R.layout.fragment_empty, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Fragment " + this.hashCode(), "onAttach")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Fragment " + this.hashCode(), "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Fragment " + this.hashCode(), "onResume")
    }

    override fun onStop() {
        Log.d("Fragment " + this.hashCode(), "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Fragment " + this.hashCode(), "onDestroyView")
        super.onDestroyView()
    }

    override fun onPause() {
        Log.d("Fragment " + this.hashCode(), "onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("Fragment " + this.hashCode(), "onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("Fragment " + this.hashCode(), "onDetach")
        super.onDetach()
    }
}