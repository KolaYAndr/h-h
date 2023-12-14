package com.example.myapplication.presentation.ui.fragments.catalog_fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.responcemodel.ResponseStates
import com.example.myapplication.databinding.FragmentCatalogBinding
import com.example.myapplication.presentation.custom_views.ItemDivider
import com.example.myapplication.utils.getError
import com.example.myapplication.utils.makeSnackBar
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CatalogFragment : Fragment() {
    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!

    private lateinit var catalogAdapter: CatalogAdapter

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

    private fun setToolbar() {
        binding.catalogToolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.settingsFragment -> {
                    findNavController().navigate(CatalogFragmentDirections.actionCatalogFragmentToSettingsFragment())
                    return@setOnMenuItemClickListener true
                }

                else -> false
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        setCatalogViewModelObserver(view)
        catalogViewModel.getProducts()
        setItemDecoration()
        setRefreshButton()
        setItemClickListener()
        setToolbar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setItemClickListener() {
        catalogAdapter.setOnItemClickListener {
            findNavController().navigate(
                CatalogFragmentDirections.actionCatalogFragmentToDetailFragment(it.id)
            )
        }
    }

    private fun setItemDecoration() {
        binding.catalogRecyclerView.addItemDecoration(ItemDivider(requireContext()))
    }

    private fun setRefreshButton() {
        binding.catalogRefreshButton.setOnClickListener {
            catalogViewModel.getProducts()
        }
    }

    private fun setCatalogViewModelObserver(view: View) {
        catalogViewModel.productsLiveData.observe(viewLifecycleOwner) { value ->
            when (value) {
                is ResponseStates.Loading -> {
                    binding.catalogViewFlipper.displayedChild = 0
                }

                is ResponseStates.Failure -> {
                    binding.catalogUnexpectedErrorDetailed.text = value.e.getError()
                    binding.catalogViewFlipper.displayedChild = 1
                }

                is ResponseStates.Success -> {
                    catalogAdapter.submitList(value.data)
                    binding.catalogViewFlipper.displayedChild = 2
                }

                else -> {
                    Log.d("error", value.toString())
                    binding.catalogViewFlipper.displayedChild = 1
                    view.makeSnackBar("Unexpected type response").show()
                }
            }
        }
    }

    private fun initAdapter() {
        catalogAdapter = CatalogAdapter()
        binding.catalogRecyclerView.apply {
            adapter = catalogAdapter
            setHasFixedSize(true)
        }
    }
}