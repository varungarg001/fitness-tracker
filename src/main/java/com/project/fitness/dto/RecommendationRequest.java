package com.project.fitness.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationRequest {

    private String userId;

    private String activityId;

    private List<String> improvements;

    private List<String> suggestions;

    private List<String> safety;

}
