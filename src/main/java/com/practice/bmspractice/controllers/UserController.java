package com.practice.bmspractice.controllers;

import com.practice.bmspractice.dtos.UserSignInRequestDto;
import com.practice.bmspractice.dtos.UserSignUpRequestDto;
import com.practice.bmspractice.dtos.UserSignUpResponseDto;
import com.practice.bmspractice.models.User;
import com.practice.bmspractice.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserSignUpResponseDto signUp(UserSignUpRequestDto userSignUpRequestDto) {
        // Implementation for user sign-up
        User user = userService.signUp(userSignUpRequestDto.getName(),
                                        userSignUpRequestDto.getEmail(),
                                        userSignUpRequestDto.getPassword());
        UserSignUpResponseDto responseDto = new UserSignUpResponseDto();
        responseDto.setUserId(user.getId());
        responseDto.setMessage("User signed up successfully");
        return responseDto;
    }

}
