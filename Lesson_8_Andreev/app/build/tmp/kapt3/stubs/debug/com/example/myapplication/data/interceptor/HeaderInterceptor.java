package com.example.myapplication.data.interceptor;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/example/myapplication/data/interceptor/HeaderInterceptor;", "Lokhttp3/Interceptor;", "preferenceStorage", "Lcom/example/myapplication/data/repository/PreferenceStorage;", "(Lcom/example/myapplication/data/repository/PreferenceStorage;)V", "token", "", "getToken", "()Ljava/lang/String;", "token$delegate", "Lkotlin/Lazy;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "app_debug"})
public final class HeaderInterceptor implements okhttp3.Interceptor {
    @org.jetbrains.annotations.NotNull
    private final com.example.myapplication.data.repository.PreferenceStorage preferenceStorage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy token$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String HEADER_AUTHORIZATION = "Authorization";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TOKEN_TYPE = "Bearer ";
    @org.jetbrains.annotations.NotNull
    public static final com.example.myapplication.data.interceptor.HeaderInterceptor.Companion Companion = null;
    
    public HeaderInterceptor(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.repository.PreferenceStorage preferenceStorage) {
        super();
    }
    
    private final java.lang.String getToken() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/myapplication/data/interceptor/HeaderInterceptor$Companion;", "", "()V", "HEADER_AUTHORIZATION", "", "TOKEN_TYPE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}