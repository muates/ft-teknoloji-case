package com.muates.ftteknolojicase.comment.controller.endpoint;

public class CommentControllerEndpoint {
    public static final String SEND_COMMENT = "/comment/send";
    public static final String GET_COMMENT_LIST_BY_PRODUCT = "/comment/product/{productId}";
    public static final String GET_COMMENT_LIST_BY_GIVEN_DATE_FOR_PRODUCT = "/comment/product/{productId}/date";
    public static final String GET_COMMENT_LIST_BY_USER = "/comment/user/{userId}";
    public static final String GET_COMMENT_LIST_BY_GIVEN_DATE_FOR_USER = "/comment/user/{userId}/date";
}
