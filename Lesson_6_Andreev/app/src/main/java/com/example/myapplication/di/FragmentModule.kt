package com.example.myapplication.di

import com.example.myapplication.presentation.ui.fragments.catalog_fragment.CatalogFragment
import com.example.myapplication.presentation.ui.fragments.sign_in_fragment.SignInFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun signInFragment(): SignInFragment

    @ContributesAndroidInjector
    abstract fun catalogFragment(): CatalogFragment
}