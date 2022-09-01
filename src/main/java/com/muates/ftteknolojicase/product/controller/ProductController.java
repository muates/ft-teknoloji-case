package com.muates.ftteknolojicase.product.controller;

import com.muates.ftteknolojicase.product.model.converter.ProductConverter;
import com.muates.ftteknolojicase.product.model.dto.ProductDto;
import com.muates.ftteknolojicase.product.model.entity.ProductEntity;
import com.muates.ftteknolojicase.product.model.request.ProductCreateRequest;
import com.muates.ftteknolojicase.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.muates.ftteknolojicase.product.controller.endpoint.ProductControllerEndpoint.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = CREATE_PRODUCT)
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductCreateRequest request) {
        ProductEntity savedProduct = productService.createProduct(request);
        return ResponseEntity.ok(ProductConverter.convertToProductResponse(savedProduct));
    }

    @GetMapping(value = GET_EXPIRED_DATE_PRODUCTS)
    public ResponseEntity<List<ProductDto>> getExpiredDateProducts() {
        List<ProductEntity> productList = productService.getExpiredDateProducts();
        return ResponseEntity.ok(ProductConverter.convertToProductList(productList));
    }

    @GetMapping(value = GET_UNEXPIRED_DATE_PRODUCTS)
    public ResponseEntity<List<ProductDto>> getUnexpiredDateProducts() {
        List<ProductEntity> productList = productService.getUnexpiredDateProducts();
        return ResponseEntity.ok(ProductConverter.convertToProductList(productList));
    }

}
