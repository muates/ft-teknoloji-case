package com.muates.ftteknolojicase.user.service.impl;

import com.muates.ftteknolojicase.exception.ResourceNotFoundException;
import com.muates.ftteknolojicase.user.model.converter.UserConverter;
import com.muates.ftteknolojicase.user.model.entity.UserEntity;
import com.muates.ftteknolojicase.user.model.request.UserCreateRequest;
import com.muates.ftteknolojicase.user.repository.UserRepository;
import com.muates.ftteknolojicase.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserCreateRequest request) {
        if (request == null) {
            return null;
        }

        return userRepository.save(UserConverter.convertToUser(request));
    }

    @Override
    public UserEntity getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new  ResourceNotFoundException("User does not found!"));
    }
}
