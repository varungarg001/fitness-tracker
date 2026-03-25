package com.project.fitness.controller;

import com.project.fitness.apiResponse.ApiResponse;
import com.project.fitness.dto.LoginRequest;
import com.project.fitness.dto.LoginResponse;
import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.model.User;
import com.project.fitness.repo.UserRepo;
import com.project.fitness.security.JwtUtils;
import com.project.fitness.service.user.UserService;
import com.project.fitness.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils  jwtUtils;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest user){
        return ResponseEntity.ok(new ApiResponse("Success",userService.register(user)));
    }

    @PostMapping("/signin")
    public ResponseEntity<ApiResponse> signIn(@RequestBody LoginRequest loginRequest){

        try{
           User user =  userRepo.findByEmail(loginRequest.getEmail());

           if(user==null){
               return ResponseEntity.status(401).body(new ApiResponse("User Not Found",null));
           }
           if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
               return ResponseEntity.status(401).body(new ApiResponse("User Not Authorize",null));
           }

           String token = jwtUtils.generateToken(user.getId(),user.getRole().name());

           return ResponseEntity.ok(new ApiResponse("Success",new LoginResponse(token,userService.getUser(user.getId()))));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Error",e.getMessage()));
        }
    }
}
