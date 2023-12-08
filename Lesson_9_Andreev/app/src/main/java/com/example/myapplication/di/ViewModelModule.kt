package com.example.myapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.presentation.ui.fragments.catalog_fragment.CatalogViewModel
import com.example.myapplication.presentation.ui.fragments.detail_fragment.DetailViewModel
import com.example.myapplication.presentation.ui.fragments.sign_in_fragment.SignInViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    abstract fun signInViewModel(signInViewModel: SignInViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CatalogViewModel::class)
    abstract fun catalogViewModel(catalogViewModel: CatalogViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun detailViewModel(detailViewModel: DetailViewModel): ViewModel
}