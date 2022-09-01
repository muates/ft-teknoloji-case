package com.muates.ftteknolojicase.product.repository;

import com.muates.ftteknolojicase.product.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(
            value = "SELECT * FROM product " +
                    "WHERE product.expiration_date < CURRENT_DATE " +
                    "AND product.expiration_date IS NOT NULL",
            nativeQuery = true
    )
    List<ProductEntity> getExpiredDateProducts();

    @Query(
            value = "SELECT * FROM product " +
                    "WHERE product.expiration_date > CURRENT_DATE " +
                    "OR product.expiration_date IS NULL",
            nativeQuery = true
    )
    List<ProductEntity> getUnexpiredDateProducts();
}
