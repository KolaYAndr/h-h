// Generated by Dagger (https://dagger.dev).
package com.example.myapplication.di;

import android.content.Context;
import com.example.myapplication.MyApplication;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ApplicationModule_ProvideApplicationContextFactory implements Factory<Context> {
  private final ApplicationModule module;

  private final Provider<MyApplication> appProvider;

  public ApplicationModule_ProvideApplicationContextFactory(ApplicationModule module,
      Provider<MyApplication> appProvider) {
    this.module = module;
    this.appProvider = appProvider;
  }

  @Override
  public Context get() {
    return provideApplicationContext(module, appProvider.get());
  }

  public static ApplicationModule_ProvideApplicationContextFactory create(ApplicationModule module,
      Provider<MyApplication> appProvider) {
    return new ApplicationModule_ProvideApplicationContextFactory(module, appProvider);
  }

  public static Context provideApplicationContext(ApplicationModule instance, MyApplication app) {
    return Preconditions.checkNotNullFromProvides(instance.provideApplicationContext(app));
  }
}