package com.example.myapplication.presentation.ui.fragments.order_ragment

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentOrderBinding
import com.example.myapplication.presentation.ui.MapActivity
import com.example.myapplication.utils.DatePickerFragment
import dagger.android.support.AndroidSupportInjection
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    private val args: OrderFragmentArgs by navArgs()

    private val orderViewModel by viewModels<OrderViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigationBack()
        setOrderInfo()
        setDateEndIconClickListener()
        setQuantityButtonAndPurchaseButton()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setQuantityButtonAndPurchaseButton() {
        binding.orderProductView.quantityButton.setIncreaseButtonClickListener {
            orderViewModel.increaseCounter()
        }
        binding.orderProductView.quantityButton.setDecreaseButtonClickListener {
            orderViewModel.decreaseCounter()
        }
        val productPrice = args.productPrice
        val observer = Observer<Int> {
            val amount = orderViewModel.productCounterLiveData.value ?: 0
            binding.orderProductView.quantityButton.setText(amount)
            binding.orderPurchaseButton.text =
                resources.getString(R.string.purchase_for, productPrice * amount)
        }
        orderViewModel.productCounterLiveData.observe(viewLifecycleOwner, observer)
    }

    private fun setDateEndIconClickListener() {
        binding.oderDateInputLayout.setEndIconOnClickListener {
            val listener =
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    val simpleDateFormat = SimpleDateFormat("dd MMMM", Locale.getDefault())
                    val text = simpleDateFormat.format(Date(year, month, dayOfMonth))
                    binding.oderDateInputEditText.setText(text)
                }
            val datePickerFragment = DatePickerFragment.createDialog(requireContext(), listener)
            datePickerFragment.show()
        }
    }

    private fun setHouseEndIconClickListener() {
        binding.orderAddressTextInputLayout.setEndIconOnClickListener {
            val intent = MapActivity.createStartIntent(requireContext())
            val activityResultLauncher =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                    if (result.resultCode == Activity.RESULT_OK) {
                        val data: Intent? = result.data
                        binding.orderAddressTextInputEditText.setText(data.toString())
                    }
                }
            activityResultLauncher.launch(intent)
        }
    }

    private fun setOrderInfo() {
        setProductImage()
        setProductName()
        setProductDepartment()
    }

    private fun setNavigationBack() {
        binding.orderToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setProductImage() {
        val imageUrl = args.productImageUrl
        Glide.with(this).load(imageUrl).into(binding.orderProductView.orderProductImage)
    }

    private fun setProductName() {
        val imageSize = args.productSize
        val productName = args.productName
        binding.orderProductView.orderProductName.text =
            resources.getString(R.string.order_product_name, imageSize, productName)
    }

    private fun setProductDepartment() {
        val productDepartment = args.productDepartment
        binding.orderProductView.orderProductDepartment.text = productDepartment
    }


}