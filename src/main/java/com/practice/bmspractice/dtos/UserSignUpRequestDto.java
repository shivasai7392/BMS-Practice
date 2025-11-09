package com.practice.bmspractice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequestDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
