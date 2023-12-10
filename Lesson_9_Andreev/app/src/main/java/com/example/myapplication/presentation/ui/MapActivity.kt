package com.example.myapplication.presentation.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMapBinding
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.layers.GeoObjectTapEvent
import com.yandex.mapkit.layers.GeoObjectTapListener
import com.yandex.mapkit.map.GeoObjectSelectionMetadata

class MapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapBinding

//    private val locationPermissionRequest =
//        registerForActivityResult(
//            ActivityResultContracts.RequestMultiplePermissions()
//        ) { permissions ->
//            when {
//                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
//                }
//
//                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
//                }
//
//                else -> {
//                }
//            }
//        }


    private val mapTapListener = GeoObjectTapListener {
        val selectionMetadata: GeoObjectSelectionMetadata = it
            .geoObject
            .metadataContainer
            .getItem(GeoObjectSelectionMetadata::class.java)
        binding.mapView.mapWindow.map.selectGeoObject(selectionMetadata)
        processAddressText(it)
        true
    }

    private fun processAddressText(geoObjectTapEvent: GeoObjectTapEvent) {
        val name = geoObjectTapEvent.geoObject.name
        if (!name.isNullOrBlank()) {
            binding.mapAddressTextView.text = name
            binding.mapAddressTextView.visibility = View.VISIBLE
        } else {
            binding.mapAddressTextView.text = ""
            binding.mapAddressTextView.visibility = View.GONE
        }
    }

    private fun setChooseClickListener(){
        binding.mapChooseTextView.setOnClickListener {
            val address = binding.mapAddressTextView.text.toString()
            if (address.isBlank())
                Toast.makeText(this, getString(R.string.choose_location_first), Toast.LENGTH_SHORT).show()
            else setResultAndFinish(address)
        }
    }

    private fun setResultAndFinish(address: String) {
        val resultIntent = Intent().apply {
            putExtra(ADDRESS_RESULT, address)
        }
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    private fun setExitButton(){
        binding.mapExitButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
//    val bestCityEverPoint = Point(59.939321, 30.315228)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.initialize(this)

        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.mapView.mapWindow.map.move(
//            CameraPosition(
//                bestCityEverPoint,
//                17.0f, 150.0f, 30.0f
//            ),
//            Animation(Animation.Type.SMOOTH, 3f),
//            null
//        )
//        locationPermissionRequest.launch(
//            arrayOf(
//                Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            )
//        )

        binding.mapView.mapWindow.map.addTapListener(mapTapListener)

        setChooseClickListener()
        setExitButton()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapView.onStart()
    }

    override fun onStop() {
        binding.mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, MapActivity::class.java)

        const val ADDRESS_RESULT = "address result"
    }
}