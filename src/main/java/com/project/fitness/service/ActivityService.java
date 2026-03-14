package com.project.fitness.service;


import com.project.fitness.model.Activity;
import com.project.fitness.repo.ActivityRepo;
import com.project.fitness.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepo activityRepo;
    private final UserService userService;



}
