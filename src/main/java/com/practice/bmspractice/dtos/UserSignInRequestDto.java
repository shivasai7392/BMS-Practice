package com.practice.bmspractice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInRequestDto {
    private String email;
    private String password;
}
