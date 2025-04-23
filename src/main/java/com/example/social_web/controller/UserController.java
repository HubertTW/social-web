package com.example.social_web.controller;


import com.example.social_web.dto.UserLogin;
import com.example.social_web.model.User;
import com.example.social_web.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody User userRequest) {
        System.out.println("[DEBUG]user_id: " + userRequest.getUserId());
        System.out.println("user_name"+userRequest.getUserName());
        System.out.println("email"+userRequest.getEmail());
        System.out.println("password"+userRequest.getPassword());
        System.out.println("cover_image"+userRequest.getCoverImage());
        System.out.println("biography"+userRequest.getBiography());

        String userId = userService.createUser(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLogin userRequest, HttpSession session) {

        Boolean res = userService.checkLoginUser(userRequest);

        if (res) {
            session.setAttribute("userId", userRequest.getUserId());
            return ResponseEntity.status(HttpStatus.OK).body("login success");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("login failed");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out");
    }






}
