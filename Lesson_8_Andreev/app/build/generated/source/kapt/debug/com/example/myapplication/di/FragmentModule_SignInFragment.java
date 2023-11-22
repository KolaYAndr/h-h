package com.example.myapplication.di;

import com.example.myapplication.presentation.ui.fragments.sign_in_fragment.SignInFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
    subcomponents = FragmentModule_SignInFragment.SignInFragmentSubcomponent.class
)
public abstract class FragmentModule_SignInFragment {
  private FragmentModule_SignInFragment() {
  }

  @Binds
  @IntoMap
  @ClassKey(SignInFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SignInFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface SignInFragmentSubcomponent extends AndroidInjector<SignInFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SignInFragment> {
    }
  }
}
