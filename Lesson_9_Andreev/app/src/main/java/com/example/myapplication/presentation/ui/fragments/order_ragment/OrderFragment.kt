package com.example.myapplication.presentation.ui.fragments.order_ragment

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.product.OrderProduct
import com.example.myapplication.data.responcemodel.ResponseStates
import com.example.myapplication.databinding.FragmentOrderBinding
import com.example.myapplication.presentation.custom_views.quantity_button.QuantityButtonViewModel
import com.example.myapplication.presentation.ui.activities.MapActivity
import com.example.myapplication.utils.DatePickerFragment
import com.example.myapplication.utils.getError
import com.example.myapplication.utils.makeSnackBar
import dagger.android.support.AndroidSupportInjection
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!
    private val args: OrderFragmentArgs by navArgs()
    private val quantityButtonViewModel by viewModels<QuantityButtonViewModel>()
    private val orderViewModel by createViewModelLazy(
        OrderViewModel::class,
        { this.viewModelStore },
        factoryProducer = { viewModelFactory }
    )

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val activityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val address = data?.getStringExtra(MapActivity.ADDRESS_RESULT)
                binding.orderAddressTextInputEditText.setText(address)
            }
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

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
        setQuantityButtonAndPurchaseButtonText()
        setHouseEndIconClickListener()
        setPurchaseButtonObserver(view)
        setPurchaseButtonFunctionality()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setPurchaseButtonObserver(view: View) {
        orderViewModel.orderLiveData.observe(viewLifecycleOwner) { value ->
            when (value) {
                is ResponseStates.Loading -> {
                    binding.orderPurchaseLoadableButton.setStateLoading()
                }

                is ResponseStates.Failure -> {
                    value.e.let {
                        view.makeSnackBar(
                            message = it.getError()
                                ?: getString(R.string.error_while_getting_response)
                        ).show()
                    }
                }

                is ResponseStates.Success -> {
                    binding.orderPurchaseLoadableButton.setStateData()
                    val responseOrder = value.data
                    val orderNumber = responseOrder.number
                    val createdDelivery = responseOrder.createdDelivery
                    view.makeSnackBar(
                        message = resources.getString(
                            R.string.order_created,
                            orderNumber,
                            createdDelivery
                        ),
                        backgroundTint = ContextCompat.getColor(
                            requireContext(),
                            R.color.dark_blue_secondary
                        )
                    ).show()
                    findNavController().navigateUp()
                }

                else -> {
                    binding.orderPurchaseLoadableButton.setStateData()
                    view.makeSnackBar(
                        message = getString(R.string.unknown_response_type)
                    ).show()
                }
            }
        }
    }

    private fun setPurchaseButtonFunctionality() {
        binding.orderPurchaseLoadableButton.clickButton {
            tryPurchasing()
        }
    }

    private fun tryPurchasing() {
        val emptinessFlag = checkEmptiness()

        if (!emptinessFlag) {
            //готовим адрес доставки и дату
            val address = binding.orderAddressTextInputEditText.text.toString()
            val apartment = binding.orderApartmentTextInputEditText.text.toString()
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val dateOrderFormat = simpleDateFormat.format(date)

            //готовим продукт
            val size = args.productSize
            val quantity = quantityButtonViewModel.productCounterLiveData.value ?: 1
            val productId = args.productId
            val orderProduct = OrderProduct(productId, size, quantity)

            //заказываем
            orderViewModel.order(address, apartment, dateOrderFormat, listOf(orderProduct))
        }
    }

    private var date = Date()

    private fun checkEmptiness() =
        binding.oderDateInputEditText.text.isNullOrEmpty() &&
                binding.orderAddressTextInputEditText.text.isNullOrEmpty() &&
                binding.orderApartmentTextInputEditText.text.isNullOrEmpty()


    private fun setQuantityButtonAndPurchaseButtonText() {
        binding.orderProductView.quantityButton.setIncreaseButtonClickListener {
            quantityButtonViewModel.increaseCounter()
        }
        binding.orderProductView.quantityButton.setDecreaseButtonClickListener {
            quantityButtonViewModel.decreaseCounter()
        }
        val productPrice = args.productPrice
        val observer = Observer<Int> {
            val quantity = quantityButtonViewModel.productCounterLiveData.value ?: 0
            if (quantity == 1) binding.orderProductView.quantityButton.setDecreaseButtonDisabled()
            if (quantity > 1) binding.orderProductView.quantityButton.setDecreaseButtonEnabled()
            binding.orderProductView.quantityButton.setText(quantity)
            binding.orderPurchaseLoadableButton.setText(
                resources.getString(R.string.purchase_for, productPrice * quantity)
            )
        }
        quantityButtonViewModel.productCounterLiveData.observe(viewLifecycleOwner, observer)
    }

    private fun setDateEndIconClickListener() {
        binding.oderDateInputLayout.setEndIconOnClickListener {
            val listener =
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    val simpleDateFormat = SimpleDateFormat("dd MMMM", Locale.getDefault())
                    date = Date(year, month, dayOfMonth)
                    val text = simpleDateFormat.format(date)
                    binding.oderDateInputEditText.setText(text)
                }
            val datePickerFragment = DatePickerFragment.createDialog(requireContext(), listener)
            datePickerFragment.show()
        }
    }

    private fun setHouseEndIconClickListener() {
        binding.orderAddressTextInputLayout.setEndIconOnClickListener {
            val mapIntent = MapActivity.createIntent(requireContext())
            activityResultLauncher.launch(mapIntent)
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