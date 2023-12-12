package com.example.myapplication.data.repository;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/example/myapplication/data/repository/PreferenceStorage;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "pref", "Landroid/content/SharedPreferences;", "value", "", "userToken", "getUserToken", "()Ljava/lang/String;", "setUserToken", "(Ljava/lang/String;)V", "Companion", "app_debug"})
public final class PreferenceStorage {
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences pref = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PREF_FILE_NAME = "pref_file";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String PREF_USER_TOKEN = "pref_user_token";
    @org.jetbrains.annotations.NotNull
    public static final com.example.myapplication.data.repository.PreferenceStorage.Companion Companion = null;
    
    @javax.inject.Inject
    public PreferenceStorage(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserToken() {
        return null;
    }
    
    public final void setUserToken(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/myapplication/data/repository/PreferenceStorage$Companion;", "", "()V", "PREF_FILE_NAME", "", "PREF_USER_TOKEN", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}