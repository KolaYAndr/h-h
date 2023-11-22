// Generated by Dagger (https://dagger.dev).
package com.example.myapplication.di;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<OkHttpClient> httpClientProvider;

  private final Provider<Gson> gsonProvider;

  public NetworkModule_ProvideRetrofitFactory(NetworkModule module,
      Provider<OkHttpClient> httpClientProvider, Provider<Gson> gsonProvider) {
    this.module = module;
    this.httpClientProvider = httpClientProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module, httpClientProvider.get(), gsonProvider.get());
  }

  public static NetworkModule_ProvideRetrofitFactory create(NetworkModule module,
      Provider<OkHttpClient> httpClientProvider, Provider<Gson> gsonProvider) {
    return new NetworkModule_ProvideRetrofitFactory(module, httpClientProvider, gsonProvider);
  }

  public static Retrofit provideRetrofit(NetworkModule instance, OkHttpClient httpClient,
      Gson gson) {
    return Preconditions.checkNotNullFromProvides(instance.provideRetrofit(httpClient, gson));
  }
}
