package com.example.myapplication.presentation.ui.fragments.sign_in_fragment;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/myapplication/presentation/ui/fragments/sign_in_fragment/SignInViewModel;", "Landroidx/lifecycle/ViewModel;", "loginUseCase", "Lcom/example/myapplication/domen/usecase/LoginUseCase;", "(Lcom/example/myapplication/domen/usecase/LoginUseCase;)V", "_loginLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/myapplication/data/responcemodel/ResponseStates;", "Lcom/example/myapplication/data/responcemodel/ResponseLogin;", "loginLiveData", "Landroidx/lifecycle/LiveData;", "getLoginLiveData", "()Landroidx/lifecycle/LiveData;", "login", "", "", "password", "app_debug"})
public final class SignInViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.myapplication.domen.usecase.LoginUseCase loginUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.example.myapplication.data.responcemodel.ResponseStates<com.example.myapplication.data.responcemodel.ResponseLogin>> _loginLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.example.myapplication.data.responcemodel.ResponseStates<com.example.myapplication.data.responcemodel.ResponseLogin>> loginLiveData = null;
    
    @javax.inject.Inject
    public SignInViewModel(@org.jetbrains.annotations.NotNull
    com.example.myapplication.domen.usecase.LoginUseCase loginUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.myapplication.data.responcemodel.ResponseStates<com.example.myapplication.data.responcemodel.ResponseLogin>> getLoginLiveData() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull
    java.lang.String login, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
}