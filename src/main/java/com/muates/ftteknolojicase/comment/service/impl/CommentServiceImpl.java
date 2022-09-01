package com.muates.ftteknolojicase.comment.service.impl;

import com.muates.ftteknolojicase.comment.model.converter.CommentConverter;
import com.muates.ftteknolojicase.comment.model.entity.CommentEntity;
import com.muates.ftteknolojicase.comment.model.request.CommentRequest;
import com.muates.ftteknolojicase.comment.model.request.DateRequest;
import com.muates.ftteknolojicase.comment.repository.CommentRepository;
import com.muates.ftteknolojicase.comment.service.CommentService;
import com.muates.ftteknolojicase.product.model.entity.ProductEntity;
import com.muates.ftteknolojicase.product.service.ProductService;
import com.muates.ftteknolojicase.user.model.entity.UserEntity;
import com.muates.ftteknolojicase.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ProductService productService;

    public CommentServiceImpl(CommentRepository commentRepository,
                              UserService userService,
                              ProductService productService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public CommentEntity sendComment(CommentRequest request) {
        if (request == null) {
            return null;
        }

        UserEntity existUser = userService.getUser(request.getUser().getId());
        ProductEntity existProduct = productService.getProduct(request.getProduct().getId());

        return commentRepository.save(CommentConverter.convertToComment(request, existUser, existProduct));
    }

    @Override
    public List<CommentEntity> getCommentListByProductId(Long productId) {
        return commentRepository.findAllByProductId(productId);
    }

    @Override
    public List<CommentEntity> getCommentListByGivenDate(DateRequest request) {
        return commentRepository.findAllByCommentDateBetween(request.getStartDate(), request.getEndDate());
    }

    @Override
    public List<CommentEntity> getCommentListByUserId(Long userId) {
        return commentRepository.findAllByUserId(userId);
    }

}
