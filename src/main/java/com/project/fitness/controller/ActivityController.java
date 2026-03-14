package com.project.fitness.controller;


import com.project.fitness.apiResponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {


    @GetMapping("/{id}/user/activities")
    public ResponseEntity<ApiResponse> getActivities(@PathVariable String id){

    }
}
