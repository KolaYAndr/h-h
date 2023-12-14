package com.example.myapplication.presentation.ui.fragments.settings_fragment

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myapplication.BuildConfig
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSettingsBinding
import com.example.myapplication.presentation.ui.fragments.bottom_sheet_fragment.BottomSheetFragment
import com.example.myapplication.utils.makeSnackBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setChangeButton()
        setOccupationEditText()
        setImagePicker()
        setToolbar()
    }

    private fun setImagePicker() {
        binding.settingsProfileImage.setOnClickListener {
            val takePicture = resources.getString(R.string.take_picture)
            val pickFromGallery = resources.getString(R.string.pick_from_gallery)
            val listOfOptions = listOf(takePicture, pickFromGallery)
            val bottomSheetFragment =
                BottomSheetFragment(REQUEST_IMAGE_KEY, IMAGE_KEY, listOfOptions)
            bottomSheetFragment.show(parentFragmentManager, IMAGE_PICK)
            parentFragmentManager.setFragmentResultListener(
                REQUEST_IMAGE_KEY,
                this
            ) { _, bundle ->
                val text = bundle.getString(IMAGE_KEY)
                bottomSheetFragment.dismiss()
                when (text) {
                    takePicture -> checkCameraPermission()
                    pickFromGallery -> pickFromGallery()
                }
            }
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isSuccess ->
            if (isSuccess) takePicture()
        }


    private var lastUri: Uri? = null

    private val cameraResultLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
            if (isSuccess) {
                binding.settingsProfileImage.setImageURI(lastUri)
            }
        }

    private fun checkCameraPermission() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
            takePicture()
        else requestPermissionLauncher.launch(
            Manifest.permission.CAMERA
        )
    }

    private fun takePicture() {
        lifecycleScope.launch {
            val file = withContext(Dispatchers.IO) {
                File.createTempFile(
                    "tmp_profile_image",
                    ".png",
                    this@SettingsFragment.context?.cacheDir
                )
            }.apply {
                createNewFile()
                deleteOnExit()
            }

            FileProvider
                .getUriForFile(
                    requireActivity().applicationContext,
                    "${BuildConfig.APPLICATION_ID}.provider",
                    file
                )
                .let {
                    lastUri = it
                    cameraResultLauncher.launch(it)
                }
        }
    }

    private val galleryResultLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { result ->
            result?.let {
                binding.settingsProfileImage.setImageURI(it)
            }
        }

    private fun pickFromGallery() {
        galleryResultLauncher.launch("image/*")
    }

    private fun setOccupationEditText() {
        binding.settingsOccupationInputEditText.setOnClickListener {
            val bottomSheetFragment =
                BottomSheetFragment(REQUEST_OCCUPATION_KEY, OCCUPATION_KEY, listOfOccupation)
            bottomSheetFragment.show(parentFragmentManager, OCCUPATION_PICK)
            parentFragmentManager.setFragmentResultListener(
                REQUEST_OCCUPATION_KEY,
                this
            ) { _, bundle ->
                val text = bundle.getString(OCCUPATION_KEY)
                binding.settingsOccupationInputEditText.setText(text)
                bottomSheetFragment.dismiss()
                if (text == "Другое") {
                    binding.settingsOtherOccupationTextInputLayout.visibility = View.VISIBLE
                } else binding.settingsOtherOccupationTextInputLayout.visibility = View.GONE
            }
        }
    }

    private fun setToolbar(){
        binding.settingsToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setChangeButton() {
        binding.settingsChangeLoadableButton.setText(getString(R.string.change))
        binding.settingsChangeLoadableButton.clickButton {
            binding.settingsChangeLoadableButton.setStateLoading()
            requireView().makeSnackBar(
                getString(R.string.profile_was_changed_successfully), ContextCompat.getColor(
                    requireContext(),
                    R.color.dark_blue_secondary
                )
            ).show()
            findNavController().navigateUp()
        }
    }

    companion object {
        private const val OCCUPATION_PICK = "occupation_pick"
        private const val REQUEST_OCCUPATION_KEY = "request_occupation"
        private const val OCCUPATION_KEY = "occupation"
        private val listOfOccupation = listOf("Разработчик", "Тестировщик", "Менеджер", "Другое")
        private const val IMAGE_PICK = "image_pick"
        private const val REQUEST_IMAGE_KEY = "request_image"
        private const val IMAGE_KEY = "image"
    }
}