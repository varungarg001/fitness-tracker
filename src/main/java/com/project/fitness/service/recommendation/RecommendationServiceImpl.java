package com.project.fitness.service.recommendation;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repo.ActivityRepo;
import com.project.fitness.repo.RecommendationRepo;
import com.project.fitness.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService{

    private final RecommendationRepo recommendationRepo;

    private final UserRepo userRepo;

    private final ActivityRepo activityRepo;


    @Override
    public Recommendation generateRecommendation(RecommendationRequest request) {

        User user = userRepo
                .findById(request.getUserId())
                .orElseThrow(()->new RuntimeException("User Not found"+request.getUserId()));

        Activity activity = activityRepo
                .findById(request.getActivityId())
                .orElseThrow(()->new RuntimeException("Activity Not found"+request.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .safety(request.getSafety())
                .suggestions(request.getSuggestions())
                .build();

        return recommendationRepo.save(recommendation);
    }

    @Override
    public List<Recommendation> getRecommendationByUserId(String userId) {
        return recommendationRepo.findByUserId(userId);
    }

    @Override
    public Recommendation getRecommendationByActivityId(String activityId) {
        return recommendationRepo.findByActivityId(activityId);
    }
}
