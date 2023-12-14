package com.example.myapplication.presentation.ui.activities

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.myapplication.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fitContentViewToInsets()

        askNotificationPermission()
        getFCMToken()
    }

    private fun fitContentViewToInsets() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {}

    private fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED
            ) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                    val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
                    alertDialogBuilder
                        .setTitle(getString(R.string.permission_notifications_title))
                        .setMessage(getString(R.string.permission_notifications_body))
                        .setNegativeButton(getString(R.string.permission_notifications_no)) { _, _ ->

                        }
                        .setPositiveButton(getString(R.string.permission_notifications_yes)) { _, _ ->
                            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        }
                    val dialog: AlertDialog = alertDialogBuilder.create()
                    dialog.show()
                } else {
                    requestPermissionLauncher.launch(Manifest.permission.CAMERA)
                }
            }
        }
    }

    private fun getFCMToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(
            OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    return@OnCompleteListener
                }
                Log.d("TOKEN", task.result)
            }
        )
    }

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }
}