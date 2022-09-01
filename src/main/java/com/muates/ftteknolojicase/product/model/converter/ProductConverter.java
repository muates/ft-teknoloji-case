package com.muates.ftteknolojicase.product.model.converter;

import com.muates.ftteknolojicase.product.model.dto.ProductDto;
import com.muates.ftteknolojicase.product.model.entity.ProductEntity;
import com.muates.ftteknolojicase.product.model.request.ProductCreateRequest;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductConverter {

    public static ProductEntity convertToProduct(ProductCreateRequest request) {
        if (request == null) {
            return null;
        }

        return ProductEntity.builder()
                .productName(request.getProductName())
                .price(request.getPrice())
                .expirationDate(request.getExpirationDate())
                .build();
    }

    public static ProductDto convertToProductResponse(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }

        return ProductDto.builder()
                .id(productEntity.getId())
                .productName(productEntity.getProductName())
                .price(productEntity.getPrice())
                .expirationDate(productEntity.getExpirationDate())
                .build();
    }

    public static List<ProductDto> convertToProductList(List<ProductEntity> productEntityList) {
        if (CollectionUtils.isEmpty(productEntityList)) {
            return Collections.emptyList();
        }

        return productEntityList.stream()
                .map(ProductConverter::convertToProductResponse)
                .collect(Collectors.toList());
    }
}
