package com.example.myapplication.di;

import com.example.myapplication.presentation.ui.fragments.catalog_fragment.CatalogFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
    subcomponents = FragmentModule_CatalogFragment.CatalogFragmentSubcomponent.class
)
public abstract class FragmentModule_CatalogFragment {
  private FragmentModule_CatalogFragment() {
  }

  @Binds
  @IntoMap
  @ClassKey(CatalogFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CatalogFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface CatalogFragmentSubcomponent extends AndroidInjector<CatalogFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<CatalogFragment> {
    }
  }
}
