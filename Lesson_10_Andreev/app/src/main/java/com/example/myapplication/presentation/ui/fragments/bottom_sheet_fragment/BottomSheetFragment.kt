package com.example.myapplication.presentation.ui.fragments.bottom_sheet_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.myapplication.databinding.BottomSheetFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment<T: Any>(
    private val requestKey: String,
    private val key: String,
    private val list: List<T>
) :
    BottomSheetDialogFragment() {
    private var _binding: BottomSheetFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var bottomSheetAdapter: BottomSheetAdapter<T>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter(list)

        bottomSheetAdapter.setOnItemClickListener {
            parentFragmentManager.setFragmentResult(
                requestKey,
                bundleOf(key to it.toString())
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(list: List<T>) {
        bottomSheetAdapter = BottomSheetAdapter()
        bottomSheetAdapter.submitList(list)
        binding.bottomSheetRecycler.apply {
            adapter = bottomSheetAdapter
            setHasFixedSize(true)
        }
    }
}
