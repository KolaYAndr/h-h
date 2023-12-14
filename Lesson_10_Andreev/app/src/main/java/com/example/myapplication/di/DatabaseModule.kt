package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.db.ProductDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideProductDataBase(context: Context): ProductDataBase {
        return Room.databaseBuilder(context, ProductDataBase::class.java, "ProductDataBase").build()
    }
}