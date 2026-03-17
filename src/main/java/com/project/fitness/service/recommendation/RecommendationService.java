package com.project.fitness.service.recommendation;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Recommendation;

import java.util.List;

public interface RecommendationService {

    Recommendation generateRecommendation(RecommendationRequest request);

    List<Recommendation> getRecommendationByUserId(String userId);

    Recommendation getRecommendationByActivityId(String activityId);
}
