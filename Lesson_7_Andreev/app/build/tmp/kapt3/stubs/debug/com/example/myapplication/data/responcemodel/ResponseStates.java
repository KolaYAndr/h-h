package com.example.myapplication.data.responcemodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/example/myapplication/data/responcemodel/ResponseStates;", "T", "", "()V", "Failure", "Loading", "Success", "Lcom/example/myapplication/data/responcemodel/ResponseStates$Failure;", "Lcom/example/myapplication/data/responcemodel/ResponseStates$Loading;", "Lcom/example/myapplication/data/responcemodel/ResponseStates$Success;", "app_debug"})
public abstract class ResponseStates<T extends java.lang.Object> {
    
    private ResponseStates() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005\u00a2\u0006\u0002\u0010\u0006R\u0015\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/myapplication/data/responcemodel/ResponseStates$Failure;", "T", "Lcom/example/myapplication/data/responcemodel/ResponseStates;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "getE", "()Ljava/lang/Exception;", "app_debug"})
    public static final class Failure<T extends java.lang.Object> extends com.example.myapplication.data.responcemodel.ResponseStates<T> {
        @org.jetbrains.annotations.NotNull
        private final java.lang.Exception e = null;
        
        public Failure(@org.jetbrains.annotations.NotNull
        java.lang.Exception e) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.Exception getE() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/myapplication/data/responcemodel/ResponseStates$Loading;", "T", "Lcom/example/myapplication/data/responcemodel/ResponseStates;", "()V", "app_debug"})
    public static final class Loading<T extends java.lang.Object> extends com.example.myapplication.data.responcemodel.ResponseStates<T> {
        
        public Loading() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/example/myapplication/data/responcemodel/ResponseStates$Success;", "T", "Lcom/example/myapplication/data/responcemodel/ResponseStates;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "app_debug"})
    public static final class Success<T extends java.lang.Object> extends com.example.myapplication.data.responcemodel.ResponseStates<T> {
        private final T data = null;
        
        public Success(T data) {
        }
        
        public final T getData() {
            return null;
        }
    }
}