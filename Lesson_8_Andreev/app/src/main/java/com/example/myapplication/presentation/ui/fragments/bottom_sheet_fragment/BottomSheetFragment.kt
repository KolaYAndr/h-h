package com.example.myapplication.presentation.ui.fragments.bottom_sheet_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.myapplication.data.product.Product
import com.example.myapplication.databinding.BottomSheetFragmentBinding
import com.example.myapplication.presentation.ui.fragments.detail_fragment.DetailFragment.Companion.REQUEST_SIZE_KEY
import com.example.myapplication.presentation.ui.fragments.detail_fragment.DetailFragment.Companion.SIZE_KEY
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment(private val product: Product) : BottomSheetDialogFragment() {
    private var _binding : BottomSheetFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var bottomSheetAdapter: BottomSheetAdapter

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
        initAdapter()

        bottomSheetAdapter.setOnItemClickListener {
            parentFragmentManager.setFragmentResult(REQUEST_SIZE_KEY , bundleOf(SIZE_KEY to it.value))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter() {
        bottomSheetAdapter = BottomSheetAdapter()
        bottomSheetAdapter.submitList(product.sizes)
        binding.bottomSheetRecycler.apply {
            adapter = bottomSheetAdapter
            setHasFixedSize(true)
        }
    }
}
