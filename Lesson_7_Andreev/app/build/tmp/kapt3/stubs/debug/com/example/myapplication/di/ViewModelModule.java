package com.example.myapplication.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\'\u00a8\u0006\f"}, d2 = {"Lcom/example/myapplication/di/ViewModelModule;", "", "()V", "bindViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/example/myapplication/di/ViewModelFactory;", "catalogViewModel", "Landroidx/lifecycle/ViewModel;", "Lcom/example/myapplication/presentation/ui/fragments/catalog_fragment/CatalogViewModel;", "signInViewModel", "Lcom/example/myapplication/presentation/ui/fragments/sign_in_fragment/SignInViewModel;", "app_debug"})
public abstract class ViewModelModule {
    
    public ViewModelModule() {
        super();
    }
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.ViewModelProvider.Factory bindViewModelFactory(@org.jetbrains.annotations.NotNull
    com.example.myapplication.di.ViewModelFactory factory);
    
    @dagger.Binds
    @dagger.multibindings.IntoMap
    @ViewModelKey(value = com.example.myapplication.presentation.ui.fragments.sign_in_fragment.SignInViewModel.class)
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.ViewModel signInViewModel(@org.jetbrains.annotations.NotNull
    com.example.myapplication.presentation.ui.fragments.sign_in_fragment.SignInViewModel signInViewModel);
    
    @dagger.Binds
    @dagger.multibindings.IntoMap
    @ViewModelKey(value = com.example.myapplication.presentation.ui.fragments.catalog_fragment.CatalogViewModel.class)
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.ViewModel catalogViewModel(@org.jetbrains.annotations.NotNull
    com.example.myapplication.presentation.ui.fragments.catalog_fragment.CatalogViewModel catalogViewModel);
}