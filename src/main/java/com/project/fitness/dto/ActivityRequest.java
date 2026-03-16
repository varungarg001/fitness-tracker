package com.project.fitness.dto;

import com.project.fitness.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRequest {

    private String userId;
    private ActivityType activityType;
    private Map<String,Object> additionalMetrics;
    private LocalDateTime startTime;
    private Integer duration;
    private Integer caloriesBurned;
}
