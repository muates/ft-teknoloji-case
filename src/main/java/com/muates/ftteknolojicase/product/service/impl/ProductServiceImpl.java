package com.muates.ftteknolojicase.product.service.impl;

import com.muates.ftteknolojicase.exception.ResourceNotFoundException;
import com.muates.ftteknolojicase.product.model.converter.ProductConverter;
import com.muates.ftteknolojicase.product.model.entity.ProductEntity;
import com.muates.ftteknolojicase.product.model.request.ProductCreateRequest;
import com.muates.ftteknolojicase.product.repository.ProductRepository;
import com.muates.ftteknolojicase.product.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity createProduct(ProductCreateRequest request) {
        if (request == null) {
            return null;
        }

        return productRepository.save(ProductConverter.convertToProduct(request));
    }

    @Override
    public ProductEntity getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product does not found!"));
    }

    @Override
    public List<ProductEntity> getExpiredDateProducts() {
        return productRepository.getExpiredDateProducts();
    }

    @Override
    public List<ProductEntity> getUnexpiredDateProducts() {
        return productRepository.getUnexpiredDateProducts();
    }
}
