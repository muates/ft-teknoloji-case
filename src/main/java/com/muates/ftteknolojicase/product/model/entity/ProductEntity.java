package com.muates.ftteknolojicase.product.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.muates.ftteknolojicase.comment.model.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static com.muates.ftteknolojicase.product.model.entity.schema.ProductEntitySchema.*;

@Entity
@Table(name = TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = PRODUCT_NAME)
    private String productName;

    @Column(name = PRICE)
    private Integer price;

    @Column(name = EXPIRATION_DATE)
    private Date expirationDate;

    @OneToMany
    @JsonManagedReference
    private List<CommentEntity> comments;

}
