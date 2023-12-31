package com.example.myapplication.di;

@dagger.Module(includes = {com.example.myapplication.di.ViewModelModule.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\'J\b\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/example/myapplication/di/FragmentModule;", "", "()V", "catalogFragment", "Lcom/example/myapplication/presentation/ui/fragments/catalog_fragment/CatalogFragment;", "signInFragment", "Lcom/example/myapplication/presentation/ui/fragments/sign_in_fragment/SignInFragment;", "app_debug"})
public abstract class FragmentModule {
    
    public FragmentModule() {
        super();
    }
    
    @dagger.android.ContributesAndroidInjector
    @org.jetbrains.annotations.NotNull
    public abstract com.example.myapplication.presentation.ui.fragments.sign_in_fragment.SignInFragment signInFragment();
    
    @dagger.android.ContributesAndroidInjector
    @org.jetbrains.annotations.NotNull
    public abstract com.example.myapplication.presentation.ui.fragments.catalog_fragment.CatalogFragment catalogFragment();
}