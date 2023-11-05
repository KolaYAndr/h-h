package com.example.lesson_2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lesson_2.databinding.FragmentEditBinding
import com.example.lesson_2.fragments.TextFragment.Companion.editedTextKey
import com.example.lesson_2.fragments.TextFragment.Companion.textKey

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
        binding.editTextId.setText(argsFromTextFragment.textViewValue)

        binding.saveButton.setOnClickListener {
            val text = binding.editTextId.text.toString()
            if (argsFromTextFragment.textViewValue == text) {
                findNavController().popBackStack()
            } else {
                parentFragmentManager.setFragmentResult(editedTextKey, bundleOf(textKey to text))
                parentFragmentManager.popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
