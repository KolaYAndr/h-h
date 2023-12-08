package com.example.myapplication.presentation.ui.fragments.detail_fragment

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.data.product.Product
import com.example.myapplication.data.responcemodel.ResponseStates
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.presentation.ui.fragments.bottom_sheet_fragment.BottomSheetFragment
import com.example.myapplication.presentation.ui.fragments.detail_fragment.adapters.DetailRecyclerAdapter
import com.example.myapplication.presentation.ui.fragments.detail_fragment.adapters.DetailViewPagerAdapter
import com.example.myapplication.utils.getError
import com.example.myapplication.utils.makeSnackBar
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()

    private lateinit var product: Product
    private lateinit var detailRecyclerAdapter: DetailRecyclerAdapter
    private lateinit var detailViewPagerAdapter: DetailViewPagerAdapter

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
        setDetailViewModelObserver(view)
        setNavigationBack()
        getProduct()
        setEndIconClickListener()
        setRefreshButton()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getProduct() {
        val id = args.productId
        detailViewModel.getProduct(id)
    }

    private fun setRefreshButton() {
        binding.detailRefreshButton.setOnClickListener {
            getProduct()
        }
    }

    private fun setPurchaseButton() {
        val size = binding.detailTextInputEditText.text.toString()
        binding.detailPurchaseButton.setOnClickListener {
            findNavController().navigate(
                DetailFragmentDirections.actionDetailFragmentToOrderFragment(
                    size, product.preview, product.title, product.department, product.price
                )
            )
        }
    }

    private fun setEndIconClickListener() {
        binding.detailTextInputLayout.setEndIconOnClickListener {
            val bottomSheetFragment = BottomSheetFragment(product)
            bottomSheetFragment.show(parentFragmentManager, "tag")
            parentFragmentManager.setFragmentResultListener(REQUEST_SIZE_KEY, this) { _, bundle ->
                val text = bundle.getString(SIZE_KEY)
                binding.detailTextInputEditText.setText(text)
                bottomSheetFragment.dismiss()
                setPurchaseButton()
            }
        }
    }

    private fun initAdapters() {
        detailViewPagerAdapter = DetailViewPagerAdapter()
        detailViewPagerAdapter.submitList(product.images)
        binding.detailViewPager.apply {
            adapter = detailViewPagerAdapter
        }

        detailRecyclerAdapter = DetailRecyclerAdapter(binding.detailViewPager)
        detailRecyclerAdapter.submitList(product.images)
        binding.detailImagesRecycler.apply {
            adapter = detailRecyclerAdapter
            setHasFixedSize(true)
        }
    }

    private fun setNavigationBack() {
        binding.detailToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setProductInfo() {
        setToolbarTitle()
        setProductPrice()
        setProductBadge()
        setProductName()
        setProductDepartment()
        setProductDescription()
        setProductBulletPoints()
    }

    private fun setToolbarTitle() {
        binding.detailToolbarText.text = product.title
    }

    private fun setProductPrice() {
        binding.detailProductPrice.text = resources.getString(R.string.product_price, product.price)
    }

    private fun setProductBadge() {
        val productBadge = product.badge.first()
        binding.detailProductBadge.text = productBadge.value

        val color = Color.parseColor(productBadge.color)
        val gradientDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = resources.getDimension(R.dimen.detail_product_badge_radius)
            setColor(color)
        }

        binding.detailProductBadge.background = gradientDrawable
    }

    private fun setProductName() {
        binding.detailProductName.text = product.title
    }

    private fun setProductDepartment() {
        binding.detailProductDepartment.text = product.department
    }

    private fun setProductDescription() {
        binding.detailProductDescription.text = product.description.substring(13)
    }

    private fun setProductBulletPoints() {
        binding.detailBulletPoints.text = buildString {
            product.details.forEach {
                append(resources.getString(R.string.bullet_string, it))
            }
        }
    }

    private fun setDetailViewModelObserver(view: View) {
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
                    binding.detailViewFlipper.displayedChild = 2
                    product = value.data
                    setProductInfo()
                    initAdapters()
                }

                else -> {
                    Log.d("error", value.toString())
                    binding.detailViewFlipper.displayedChild = 1
                    view.makeSnackBar("Unexpected type response").show()
                }
            }
        }
    }

    companion object {
        const val REQUEST_SIZE_KEY = "request size"
        const val SIZE_KEY = "size"
    }
}