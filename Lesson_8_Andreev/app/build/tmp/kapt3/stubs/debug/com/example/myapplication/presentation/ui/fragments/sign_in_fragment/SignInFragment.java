package com.example.myapplication.presentation.ui.fragments.sign_in_fragment;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\u001a\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010\'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\u0018H\u0002J\b\u0010*\u001a\u00020\u0018H\u0002J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u0018H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006-"}, d2 = {"Lcom/example/myapplication/presentation/ui/fragments/sign_in_fragment/SignInFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/myapplication/databinding/FragmentSignInBinding;", "binding", "getBinding", "()Lcom/example/myapplication/databinding/FragmentSignInBinding;", "signInViewModel", "Lcom/example/myapplication/presentation/ui/fragments/sign_in_fragment/SignInViewModel;", "getSignInViewModel", "()Lcom/example/myapplication/presentation/ui/fragments/sign_in_fragment/SignInViewModel;", "signInViewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "checkEmptiness", "", "checkErrors", "goToCatalogScreen", "", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setErrorIcons", "setErrors", "setLoginDoOnTextChange", "setPasswordDoOnTextChange", "setSignInViewModelObserver", "tryLoggingIn", "app_debug"})
public final class SignInFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.example.myapplication.databinding.FragmentSignInBinding _binding;
    @javax.inject.Inject
    public androidx.lifecycle.ViewModelProvider.Factory viewModelFactory;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy signInViewModel$delegate = null;
    
    public SignInFragment() {
        super();
    }
    
    private final com.example.myapplication.databinding.FragmentSignInBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.ViewModelProvider.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.ViewModelProvider.Factory p0) {
    }
    
    private final com.example.myapplication.presentation.ui.fragments.sign_in_fragment.SignInViewModel getSignInViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    private final void setSignInViewModelObserver(android.view.View view) {
    }
    
    private final void tryLoggingIn() {
    }
    
    private final void goToCatalogScreen() {
    }
    
    private final boolean checkErrors() {
        return false;
    }
    
    private final boolean checkEmptiness() {
        return false;
    }
    
    private final void setErrorIcons() {
    }
    
    private final void setErrors() {
    }
    
    private final void setPasswordDoOnTextChange() {
    }
    
    private final void setLoginDoOnTextChange() {
    }
}