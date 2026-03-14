package com.project.fitness.service;


import com.project.fitness.DTO.RegisterRequest;
import com.project.fitness.DTO.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    private final ModelMapper modelMapper;

    public UserResponse register(RegisterRequest request) {

//        User user = new  User(
//
//                null,
//                request.getEmail(),
//                request.getPassword(),
//                request.getFirstName(),
//                request.getLastName(),
//                Instant.parse("2026-03-11T02:46:21.671Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                Instant.parse("2026-03-11T02:46:21.671Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                List.of(),
//                List.of()
//
//        );

        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .build();

        return convertToUserDto(userRepo.save(user));
    }

    public UserResponse getUser(String id){
        return convertToUserDto(userRepo.findById(id).orElse(null));
    }

    public UserResponse convertToUserDto(User user){

        return modelMapper.map(user,UserResponse.class);
    }

}
