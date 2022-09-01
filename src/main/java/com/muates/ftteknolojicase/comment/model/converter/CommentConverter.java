package com.muates.ftteknolojicase.comment.model.converter;

import com.muates.ftteknolojicase.comment.model.dto.CommentDto;
import com.muates.ftteknolojicase.comment.model.entity.CommentEntity;
import com.muates.ftteknolojicase.comment.model.request.CommentRequest;
import com.muates.ftteknolojicase.product.model.entity.ProductEntity;
import com.muates.ftteknolojicase.user.model.entity.UserEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommentConverter {

    public static CommentEntity convertToComment(CommentRequest request, UserEntity user, ProductEntity product) {
        if (request == null) {
            return null;
        }

        return CommentEntity.builder()
                .productComment(request.getProductComment())
                .commentDate(new Date())
                .product(product)
                .user(user)
                .build();
    }

    public static CommentDto convertToCommentResponse(CommentEntity commentEntity) {
        if (commentEntity == null) {
            return null;
        }

        return CommentDto.builder()
                .id(commentEntity.getId())
                .productComment(commentEntity.getProductComment())
                .commentDate(commentEntity.getCommentDate())
                .product(commentEntity.getProduct())
                .user(commentEntity.getUser())
                .build();
    }

    public static List<CommentDto> convertToCommentListResponse(List<CommentEntity> commentEntityList) {
        if (CollectionUtils.isEmpty(commentEntityList)) {
            return Collections.emptyList();
        }

        return commentEntityList
                .stream()
                .map(CommentConverter::convertToCommentResponse)
                .collect(Collectors.toList());
    }

    public static List<CommentDto> convertToCommentListByProductId(List<CommentEntity> commentEntityList, Long productId) {
        if (CollectionUtils.isEmpty(commentEntityList)) {
            return Collections.emptyList();
        }

        return commentEntityList
                .stream()
                .filter(commentEntity -> Objects.equals(commentEntity.getProduct().getId(), productId))
                .map(CommentConverter::convertToCommentResponse)
                .collect(Collectors.toList());
    }

    public static List<CommentDto> convertToCommentListByUserId(List<CommentEntity> commentEntityList, Long userId) {
        if (CollectionUtils.isEmpty(commentEntityList)) {
            return Collections.emptyList();
        }

        return commentEntityList
                .stream()
                .filter(commentEntity -> Objects.equals(commentEntity.getUser().getId(), userId))
                .map(CommentConverter::convertToCommentResponse)
                .collect(Collectors.toList());
    }

}
