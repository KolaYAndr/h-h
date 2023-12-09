package com.example.myapplication.presentation.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMapBinding
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.layers.GeoObjectTapListener
import com.yandex.mapkit.map.GeoObjectSelectionMetadata

class MapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapBinding

    private val locationPermissionRequest =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                }

                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                }

                else -> {
                }
            }
        }

    private val mapTapListener = GeoObjectTapListener {
        val selectionMetadata: GeoObjectSelectionMetadata = it
            .geoObject
            .metadataContainer
            .getItem(GeoObjectSelectionMetadata::class.java)
        binding.mapView.mapWindow.map.selectGeoObject(selectionMetadata)
        binding.mapBottomTextView.text = it.geoObject.name
        binding.mapBottomTextView.visibility = View.VISIBLE
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.initialize(this)

        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Geocoder(this)

        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )

        binding.mapView.mapWindow.map.addTapListener(mapTapListener)
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
        fun createStartIntent(context: Context): Intent {
            return Intent(context, MapActivity::class.java)
        }
    }
}