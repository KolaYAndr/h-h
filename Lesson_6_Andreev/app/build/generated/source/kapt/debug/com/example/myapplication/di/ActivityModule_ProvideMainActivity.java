package com.example.myapplication.di;

import com.example.myapplication.presentation.ui.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
    subcomponents = ActivityModule_ProvideMainActivity.MainActivitySubcomponent.class
)
public abstract class ActivityModule_ProvideMainActivity {
  private ActivityModule_ProvideMainActivity() {
  }

  @Binds
  @IntoMap
  @ClassKey(MainActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {
    }
  }
}
