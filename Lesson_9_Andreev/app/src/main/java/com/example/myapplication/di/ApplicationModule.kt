package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.MyApplication
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule {
    @Provides
    fun provideApplicationContext(app: MyApplication): Context {
        return app.applicationContext
    }
}