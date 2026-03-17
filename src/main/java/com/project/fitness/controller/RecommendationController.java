package com.project.fitness.controller;

import com.project.fitness.apiResponse.ApiResponse;
import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.enums.Messages;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.recommendation.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<ApiResponse> generateRecommendation(@RequestBody RecommendationRequest request){
        Recommendation recommendation = recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(new ApiResponse(Messages.SUCCESS.getValue(), recommendation));
    }

    @GetMapping("/user")
    public ResponseEntity<ApiResponse> getUserRecommendations(@RequestHeader(value = "X-User-ID") String userId){

        return ResponseEntity.ok(new ApiResponse(Messages.SUCCESS.getValue(), recommendationService.getRecommendationByUserId(userId)));
    }

    @GetMapping("/activity")
    public ResponseEntity<ApiResponse> getActivityRecommendations(@RequestHeader(value = "X-Activity-ID") String activityId){

        return ResponseEntity.ok(new ApiResponse(Messages.SUCCESS.getValue(), recommendationService.getRecommendationByActivityId(activityId)));
    }
}
