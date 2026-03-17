package com.project.fitness.service.user;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;

public interface UserService {

    UserResponse register(RegisterRequest request);
    UserResponse getUser(String id);
    UserResponse convertToUserDto(User user);
}
