package com.example.myapplication.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bH\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/myapplication/di/NetworkModule;", "", "()V", "provideApiService", "Lcom/example/myapplication/data/ApiLesson;", "retrofit", "Lretrofit2/Retrofit;", "provideGson", "Lcom/google/gson/Gson;", "provideOkHttp", "Lokhttp3/OkHttpClient;", "preferenceStorage", "Lcom/example/myapplication/data/repository/PreferenceStorage;", "provideRetrofit", "kotlin.jvm.PlatformType", "httpClient", "gson", "Companion", "app_debug"})
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BASE_ENDPOINT = "http://45.144.64.179/cowboys/api/";
    @org.jetbrains.annotations.NotNull
    public static final com.example.myapplication.di.NetworkModule.Companion Companion = null;
    
    public NetworkModule() {
        super();
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final okhttp3.OkHttpClient provideOkHttp(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.repository.PreferenceStorage preferenceStorage) {
        return null;
    }
    
    @dagger.Provides
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient httpClient, @org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.example.myapplication.data.ApiLesson provideApiService(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/myapplication/di/NetworkModule$Companion;", "", "()V", "BASE_ENDPOINT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}