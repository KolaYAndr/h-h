// Generated by Dagger (https://dagger.dev).
package com.example.myapplication.data.repository;

import com.example.myapplication.data.ApiLesson;
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
public final class LoginRepository_Factory implements Factory<LoginRepository> {
  private final Provider<ApiLesson> apiLessonProvider;

  public LoginRepository_Factory(Provider<ApiLesson> apiLessonProvider) {
    this.apiLessonProvider = apiLessonProvider;
  }

  @Override
  public LoginRepository get() {
    return newInstance(apiLessonProvider.get());
  }

  public static LoginRepository_Factory create(Provider<ApiLesson> apiLessonProvider) {
    return new LoginRepository_Factory(apiLessonProvider);
  }

  public static LoginRepository newInstance(ApiLesson apiLesson) {
    return new LoginRepository(apiLesson);
  }
}
