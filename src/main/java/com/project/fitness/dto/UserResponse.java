package com.project.fitness.dto;

import com.project.fitness.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String id;
    private String email;
    private UserRole role;
    private String firstName;
    private String lastName;
    private String createdAt;
    private String updatedAt;
}
