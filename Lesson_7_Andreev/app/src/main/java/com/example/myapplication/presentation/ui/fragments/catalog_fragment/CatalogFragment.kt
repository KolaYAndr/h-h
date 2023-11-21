package com.example.myapplication.presentation.ui.fragments.catalog_fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.responcemodel.ResponseStates
import com.example.myapplication.databinding.FragmentCatalogBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CatalogFragment : Fragment() {
    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!

    private val catalogViewModel by createViewModelLazy(
        CatalogViewModel::class,
        { this.viewModelStore },
        factoryProducer = { viewModelFactory }
    )

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCatalogViewModelObserver()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setCatalogViewModelObserver() {
        catalogViewModel.productData.observe(viewLifecycleOwner) { value ->
            when (value) {
                is ResponseStates.Loading -> {
                }

                is ResponseStates.Failure -> {

                }

                is ResponseStates.Success -> {

                }

                else -> {

                }
            }
        }
    }
}