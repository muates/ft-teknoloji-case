package com.muates.ftteknolojicase.user.controller;

import com.muates.ftteknolojicase.user.model.converter.UserConverter;
import com.muates.ftteknolojicase.user.model.dto.UserDto;
import com.muates.ftteknolojicase.user.model.entity.UserEntity;
import com.muates.ftteknolojicase.user.model.request.UserCreateRequest;
import com.muates.ftteknolojicase.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.muates.ftteknolojicase.user.controller.endpoint.UserControllerEndpoint.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = CREATE_USER)
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserCreateRequest request) {
        UserEntity savedUser = userService.createUser(request);
        return ResponseEntity.ok(UserConverter.convertToUserResponse(savedUser));
    }
}
