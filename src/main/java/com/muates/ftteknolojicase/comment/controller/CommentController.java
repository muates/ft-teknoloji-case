package com.muates.ftteknolojicase.comment.controller;

import com.muates.ftteknolojicase.comment.model.converter.CommentConverter;
import com.muates.ftteknolojicase.comment.model.dto.CommentDto;
import com.muates.ftteknolojicase.comment.model.entity.CommentEntity;
import com.muates.ftteknolojicase.comment.model.request.CommentRequest;
import com.muates.ftteknolojicase.comment.model.request.DateRequest;
import com.muates.ftteknolojicase.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.muates.ftteknolojicase.comment.controller.endpoint.CommentControllerEndpoint.*;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = SEND_COMMENT)
    public ResponseEntity<CommentDto> sendComment(@RequestBody @Valid CommentRequest request) {
        CommentEntity savedComment = commentService.sendComment(request);
        return ResponseEntity.ok(CommentConverter.convertToCommentResponse(savedComment));
    }

    @GetMapping(value = GET_COMMENT_LIST_BY_PRODUCT)
    public ResponseEntity<List<CommentDto>> getCommentListByProductId(@PathVariable Long productId) {
        List<CommentEntity> commentList = commentService.getCommentListByProductId(productId);
        return ResponseEntity.ok(CommentConverter.convertToCommentListResponse(commentList));
    }

    @GetMapping(value = GET_COMMENT_LIST_BY_GIVEN_DATE_FOR_PRODUCT)
    public ResponseEntity<List<CommentDto>> getCommentListByGivenDateForProduct(@ModelAttribute @Valid DateRequest request,
                                                                      @PathVariable Long productId) {
        List<CommentEntity> commentList = commentService.getCommentListByGivenDate(request);
        return ResponseEntity.ok(CommentConverter.convertToCommentListByProductId(commentList, productId));
    }

    @GetMapping(value = GET_COMMENT_LIST_BY_USER)
    public ResponseEntity<List<CommentDto>> getCommentListByUser(@PathVariable Long userId) {
        List<CommentEntity> commentList = commentService.getCommentListByUserId(userId);
        return ResponseEntity.ok(CommentConverter.convertToCommentListResponse(commentList));
    }

    @GetMapping(value = GET_COMMENT_LIST_BY_GIVEN_DATE_FOR_USER)
    public ResponseEntity<List<CommentDto>> getCommentListByGivenDateForUser(@ModelAttribute @Valid DateRequest request,
                                                                             @PathVariable Long userId) {
        List<CommentEntity> commentList = commentService.getCommentListByGivenDate(request);
        return ResponseEntity.ok(CommentConverter.convertToCommentListByUserId(commentList, userId));
    }

}
