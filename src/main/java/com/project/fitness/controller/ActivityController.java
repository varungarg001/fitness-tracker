package com.project.fitness.controller;


import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.apiResponse.ApiResponse;
import com.project.fitness.service.activity.ActivityService;
import com.project.fitness.service.activity.ActivityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.fitness.enums.Messages.NO_ACTIVITY;
import static com.project.fitness.enums.Messages.SUCCESS;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping("/track/activities")
    public ResponseEntity<ApiResponse> trackActivity(@RequestBody ActivityRequest activityRequest){
        return ResponseEntity.ok(new ApiResponse(SUCCESS.getValue(), activityService.trackActivity(activityRequest)));
    }

    @GetMapping("/{id}/user/activities")
    public ResponseEntity<ApiResponse> getActivities(@PathVariable String id){

        List<ActivityResponse> activityList = activityService.getActivitiesOfUser(id);

        if(!activityList.isEmpty()){
            return ResponseEntity.ok(new ApiResponse(SUCCESS.getValue(), activityList));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(NO_ACTIVITY.getValue(), null));
    }
}
