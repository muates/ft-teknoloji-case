package com.muates.ftteknolojicase.comment.service;

import com.muates.ftteknolojicase.comment.model.entity.CommentEntity;
import com.muates.ftteknolojicase.comment.model.request.CommentRequest;
import com.muates.ftteknolojicase.comment.model.request.DateRequest;

import java.util.List;

public interface CommentService {
    CommentEntity sendComment(CommentRequest request);
    List<CommentEntity> getCommentListByProductId(Long productId);
    List<CommentEntity> getCommentListByGivenDate(DateRequest request);
    List<CommentEntity> getCommentListByUserId(Long userId);
}
