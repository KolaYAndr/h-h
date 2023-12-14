package com.example.myapplication.di

import com.example.myapplication.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        FragmentModule::class,
        DatabaseModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MyApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: MyApplication): ApplicationComponent
    }
}