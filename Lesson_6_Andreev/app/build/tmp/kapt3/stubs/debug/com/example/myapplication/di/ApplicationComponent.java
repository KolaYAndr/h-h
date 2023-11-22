package com.example.myapplication.di;

@javax.inject.Singleton
@dagger.Component(modules = {dagger.android.AndroidInjectionModule.class, com.example.myapplication.di.NetworkModule.class, com.example.myapplication.di.ApplicationModule.class, com.example.myapplication.di.ActivityModule.class, com.example.myapplication.di.FragmentModule.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/myapplication/di/ApplicationComponent;", "Ldagger/android/AndroidInjector;", "Lcom/example/myapplication/MyApplication;", "Factory", "app_debug"})
public abstract interface ApplicationComponent extends dagger.android.AndroidInjector<com.example.myapplication.MyApplication> {
    
    @dagger.Component.Factory
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/myapplication/di/ApplicationComponent$Factory;", "", "create", "Lcom/example/myapplication/di/ApplicationComponent;", "applicationContext", "Lcom/example/myapplication/MyApplication;", "app_debug"})
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.example.myapplication.di.ApplicationComponent create(@dagger.BindsInstance
        @org.jetbrains.annotations.NotNull
        com.example.myapplication.MyApplication applicationContext);
    }
}