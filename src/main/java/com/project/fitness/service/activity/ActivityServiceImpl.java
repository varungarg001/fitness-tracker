package com.project.fitness.service.activity;


import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.repo.ActivityRepo;
import com.project.fitness.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements  ActivityService {

    private final ActivityRepo activityRepo;

    private final UserRepo userRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<ActivityResponse> getActivitiesOfUser(String userId){
        List<Activity> activitiesList = activityRepo.findByUserId(userId);

        return activitiesList.stream().map(this::mapToResponse).toList();
    }

    @Override
    public ActivityResponse trackActivity(ActivityRequest activityRequest){
        Activity activity = Activity.builder()
                .activityType(activityRequest.getActivityType())
                .additionalMetrics(activityRequest.getAdditionalMetrics())
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .startTime(activityRequest.getStartTime())
                .duration(activityRequest.getDuration())
                .user(userRepo.findById(activityRequest.getUserId()).orElse(null))
                .build();

        Activity savedActivity = activityRepo.save(activity);
        return mapToResponse(savedActivity);

    }

    @Override
    public ActivityResponse mapToResponse(Activity activity){
        return modelMapper.map(activity, ActivityResponse.class);
    }



}
