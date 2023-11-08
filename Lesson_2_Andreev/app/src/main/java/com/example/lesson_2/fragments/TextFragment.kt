package com.example.lesson_2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lesson_2.databinding.FragmentTextBinding

class TextFragment : Fragment() {
    private var _binding: FragmentTextBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener {
            val text = binding.textHolder.text.toString()
            findNavController().navigate(TextFragmentDirections.actionTextFragmentToEditFragment(text))
        }

        parentFragmentManager.setFragmentResultListener(EDITED_TEXT_KEY, this) { _, bundle ->
            val text = bundle.getString(TEXT_KEY)
            binding.textHolder.text = text
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EDITED_TEXT_KEY = "editedText"
        const val TEXT_KEY = "text"
    }
}