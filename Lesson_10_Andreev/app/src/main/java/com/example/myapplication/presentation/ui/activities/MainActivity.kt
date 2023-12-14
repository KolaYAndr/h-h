package com.example.myapplication.presentation.ui.activities

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.myapplication.R
import com.example.myapplication.data.services.ServiceWithBoth
import com.example.myapplication.data.services.ServiceWithBound
import com.example.myapplication.data.services.ServiceWithLaunch
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fitContentViewToInsets()

        askNotificationPermission()
        getFCMToken()

        startService(Intent(this, ServiceWithLaunch::class.java))

        Intent(this, ServiceWithBound::class.java).also { intent ->
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }

        val serviceWithBothIntent = Intent(this, ServiceWithBoth::class.java)
        startService(serviceWithBothIntent)
        stopService(serviceWithBothIntent)

        serviceWithBothIntent.also { intent ->
            bindService(intent, serviceConnectionBoth, Context.BIND_AUTO_CREATE)
        }
    }

    private var boundService: ServiceWithBound? = null
    private var bound: Boolean = false
    private var boundBoth = false

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.d(ServiceWithBound.TAG, "onServiceDisconnected")
            boundService = null
            bound = false
        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            Log.d(ServiceWithBound.TAG, "onServiceConnected")
            boundService = ServiceWithBound()
            bound = true
        }
    }

    private val serviceConnectionBoth = object : ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            Log.d(ServiceWithBoth.TAG, "onServiceConnected")
            boundService = ServiceWithBound()
            boundBoth = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.d(ServiceWithBoth.TAG, "onServiceDisconnected")
            boundService = null
            boundBoth = false
        }
    }

    override fun onStop() {
        super.onStop()
        if (bound) {
            unbindService(serviceConnection)
            bound = false
        }
        if (boundBoth) {
            unbindService(serviceConnectionBoth)
            boundBoth = false
        }
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