package com.example.myapplication.domen.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/myapplication/domen/usecase/LoginUseCase;", "", "repository", "Lcom/example/myapplication/data/repository/LoginRepository;", "preferenceStorage", "Lcom/example/myapplication/data/repository/PreferenceStorage;", "(Lcom/example/myapplication/data/repository/LoginRepository;Lcom/example/myapplication/data/repository/PreferenceStorage;)V", "execute", "Lcom/example/myapplication/data/responcemodel/ResponseLogin;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class LoginUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.example.myapplication.data.repository.LoginRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.myapplication.data.repository.PreferenceStorage preferenceStorage = null;
    
    @javax.inject.Inject
    public LoginUseCase(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.repository.LoginRepository repository, @org.jetbrains.annotations.NotNull
    com.example.myapplication.data.repository.PreferenceStorage preferenceStorage) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object execute(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.myapplication.data.responcemodel.ResponseLogin> $completion) {
        return null;
    }
}