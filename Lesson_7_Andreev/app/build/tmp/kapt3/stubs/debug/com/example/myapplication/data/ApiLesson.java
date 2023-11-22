package com.example.myapplication.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/myapplication/data/ApiLesson;", "", "getProducts", "Lcom/example/myapplication/data/responcemodel/BaseResponse;", "", "Lcom/example/myapplication/data/product/Product;", "pageSize", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/example/myapplication/data/responcemodel/ResponseLogin;", "requestLogin", "Lcom/example/myapplication/data/requestmodel/RequestLogin;", "(Lcom/example/myapplication/data/requestmodel/RequestLogin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiLesson {
    
    @retrofit2.http.PUT(value = "user/signin")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object login(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.myapplication.data.requestmodel.RequestLogin requestLogin, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.myapplication.data.responcemodel.BaseResponse<com.example.myapplication.data.responcemodel.ResponseLogin>> $completion);
    
    @retrofit2.http.GET(value = "products")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getProducts(@retrofit2.http.Query(value = "pageSize")
    int pageSize, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.myapplication.data.responcemodel.BaseResponse<java.util.List<com.example.myapplication.data.product.Product>>> $completion);
}