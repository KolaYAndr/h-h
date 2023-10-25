package com.example.lesson_2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lesson_2.databinding.FragmentEditBinding

class EditFragment : Fragment() {
    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!

    private val argsFromTextFragment: EditFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editTextId.setText(argsFromTextFragment.editTextValue)

        binding.saveButton.setOnClickListener {
            val text = binding.editTextId.text.toString()
            findNavController().navigate(EditFragmentDirections.actionEditFragmentToTextFragment(text))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}