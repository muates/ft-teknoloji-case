package com.muates.ftteknolojicase.product.service;

import com.muates.ftteknolojicase.product.model.entity.ProductEntity;
import com.muates.ftteknolojicase.product.model.request.ProductCreateRequest;

import java.util.List;

public interface ProductService {
    ProductEntity createProduct(ProductCreateRequest request);
    ProductEntity getProduct(Long productId);
    List<ProductEntity> getExpiredDateProducts();
    List<ProductEntity> getUnexpiredDateProducts();

}
