package com.example.myapplication.presentation.ui.fragments.detail_fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.myapplication.data.responcemodel.ResponseStates
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.utils.getError
import com.example.myapplication.utils.makeSnackBar
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel by createViewModelLazy(
        DetailViewModel::class,
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
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCatalogViewModelObserver(view)

        getProduct()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getProduct(){
        val id = args.productId
        detailViewModel.getProduct(id)
    }

    private fun setCatalogViewModelObserver(view: View) {
        detailViewModel.productLiveData.observe(viewLifecycleOwner) { value ->
            when (value) {
                is ResponseStates.Loading -> {
                    binding.detailViewFlipper.displayedChild = 0
                }

                is ResponseStates.Failure -> {
                    binding.detailUnexpectedErrorDetailed.text = value.e.getError()
                    binding.detailViewFlipper.displayedChild = 1
                }

                is ResponseStates.Success -> {
                    //catalogAdapter.differ.submitList(value.data)
                    binding.detailViewFlipper.displayedChild = 2
                }

                else -> {
                    Log.d("error", value.toString())
                    binding.detailViewFlipper.displayedChild = 1
                    view.makeSnackBar("Unexpected type response").show()
                }
            }
        }
    }
}