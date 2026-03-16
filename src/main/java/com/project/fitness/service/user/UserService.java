package com.project.fitness.service.user;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;

public interface UserService {

    public UserResponse register(RegisterRequest request);
    public UserResponse getUser(String id);
    UserResponse convertToUserDto(User user);
}
