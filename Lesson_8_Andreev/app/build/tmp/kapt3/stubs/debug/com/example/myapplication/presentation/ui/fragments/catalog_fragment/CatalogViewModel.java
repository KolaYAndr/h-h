package com.example.myapplication.presentation.ui.fragments.catalog_fragment;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eR \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/myapplication/presentation/ui/fragments/catalog_fragment/CatalogViewModel;", "Landroidx/lifecycle/ViewModel;", "productUseCase", "Lcom/example/myapplication/domen/usecase/ProductUseCase;", "(Lcom/example/myapplication/domen/usecase/ProductUseCase;)V", "_productLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/myapplication/data/responcemodel/ResponseStates;", "", "Lcom/example/myapplication/data/product/Product;", "productData", "getProductData", "()Landroidx/lifecycle/MutableLiveData;", "getProducts", "", "Companion", "app_debug"})
public final class CatalogViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.myapplication.domen.usecase.ProductUseCase productUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.example.myapplication.data.responcemodel.ResponseStates<java.util.List<com.example.myapplication.data.product.Product>>> _productLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.example.myapplication.data.responcemodel.ResponseStates<java.util.List<com.example.myapplication.data.product.Product>>> productData = null;
    private static final int USUAL_REQUEST_PRODUCT_SIZE = 0;
    @org.jetbrains.annotations.NotNull
    public static final com.example.myapplication.presentation.ui.fragments.catalog_fragment.CatalogViewModel.Companion Companion = null;
    
    @javax.inject.Inject
    public CatalogViewModel(@org.jetbrains.annotations.NotNull
    com.example.myapplication.domen.usecase.ProductUseCase productUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.example.myapplication.data.responcemodel.ResponseStates<java.util.List<com.example.myapplication.data.product.Product>>> getProductData() {
        return null;
    }
    
    public final void getProducts() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/myapplication/presentation/ui/fragments/catalog_fragment/CatalogViewModel$Companion;", "", "()V", "USUAL_REQUEST_PRODUCT_SIZE", "", "getUSUAL_REQUEST_PRODUCT_SIZE", "()I", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final int getUSUAL_REQUEST_PRODUCT_SIZE() {
            return 0;
        }
    }
}