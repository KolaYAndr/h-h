package com.example.myapplication.data.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ServiceWithLaunch : Service(){
    private val TAG = "LAUNCH"
    override fun onBind(p0: Intent?): IBinder? {
        Log.d(TAG, "onBind")
        return null
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")
        return START_STICKY
    }
}