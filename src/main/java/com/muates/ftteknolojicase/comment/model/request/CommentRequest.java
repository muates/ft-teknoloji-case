package com.muates.ftteknolojicase.comment.model.request;

import com.muates.ftteknolojicase.product.model.entity.ProductEntity;
import com.muates.ftteknolojicase.user.model.entity.UserEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CommentRequest {

    @Size(max = 500)
    @NotBlank
    private String productComment;

    @NotNull
    private ProductEntity product;

    @NotNull
    private UserEntity user;

}
