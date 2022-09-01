package com.muates.ftteknolojicase.user.service;

import com.muates.ftteknolojicase.user.model.entity.UserEntity;
import com.muates.ftteknolojicase.user.model.request.UserCreateRequest;

public interface UserService {
    UserEntity createUser(UserCreateRequest request);

    UserEntity getUser(Long userId);
}
