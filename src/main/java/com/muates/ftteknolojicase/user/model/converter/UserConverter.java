package com.muates.ftteknolojicase.user.model.converter;

import com.muates.ftteknolojicase.user.model.dto.UserDto;
import com.muates.ftteknolojicase.user.model.entity.UserEntity;
import com.muates.ftteknolojicase.user.model.request.UserCreateRequest;

public class UserConverter {

    public static UserEntity convertToUser(UserCreateRequest request) {
        if (request == null) {
            return null;
        }

        return UserEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .mail(request.getMail())
                .phone(request.getPhone())
                .build();
    }

    public static UserDto convertToUserResponse(UserEntity user) {
        if (user == null) {
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .mail(user.getMail())
                .phone(user.getPhone())
                .build();
    }
}
