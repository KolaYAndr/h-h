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
            val notificationPermission = Manifest.permission.POST_NOTIFICATIONS

            if (ContextCompat.checkSelfPermission(this, notificationPermission) !=
                PackageManager.PERMISSION_GRANTED
            ) {
                if (shouldShowRequestPermissionRationale(notificationPermission)) {
                    // Если пользователь уже отклонил запрос уведомлений, покажем ему объяснение
                    val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
                    alertDialogBuilder
                        .setTitle(getString(R.string.permission_notifications_title))
                        .setMessage(getString(R.string.permission_notifications_body))
                        .setNegativeButton(getString(R.string.permission_notifications_no)) { _, _ -> }
                        .setPositiveButton(getString(R.string.permission_notifications_yes)) { _, _ ->
                            requestPermissionLauncher.launch(notificationPermission)
                        }
                    val dialog: AlertDialog = alertDialogBuilder.create()
                    dialog.show()
                } else {
                    // Запрос уведомлений впервые
                    requestPermissionLauncher.launch(notificationPermission)
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