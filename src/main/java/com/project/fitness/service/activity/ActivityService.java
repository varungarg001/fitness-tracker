package com.project.fitness.service.activity;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;

import java.util.List;

public interface ActivityService {
    List<ActivityResponse> getActivitiesOfUser(String userId);

    ActivityResponse trackActivity(ActivityRequest activityRequest);

    ActivityResponse mapToResponse(Activity activity);
}
