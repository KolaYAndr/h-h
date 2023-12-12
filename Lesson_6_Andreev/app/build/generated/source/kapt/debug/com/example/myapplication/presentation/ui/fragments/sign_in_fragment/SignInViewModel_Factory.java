// Generated by Dagger (https://dagger.dev).
package com.example.myapplication.presentation.ui.fragments.sign_in_fragment;

import com.example.myapplication.domen.usecase.LoginUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class SignInViewModel_Factory implements Factory<SignInViewModel> {
  private final Provider<LoginUseCase> loginUseCaseProvider;

  public SignInViewModel_Factory(Provider<LoginUseCase> loginUseCaseProvider) {
    this.loginUseCaseProvider = loginUseCaseProvider;
  }

  @Override
  public SignInViewModel get() {
    return newInstance(loginUseCaseProvider.get());
  }

  public static SignInViewModel_Factory create(Provider<LoginUseCase> loginUseCaseProvider) {
    return new SignInViewModel_Factory(loginUseCaseProvider);
  }

  public static SignInViewModel newInstance(LoginUseCase loginUseCase) {
    return new SignInViewModel(loginUseCase);
  }
}
