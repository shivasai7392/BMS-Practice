package com.practice.bmspractice;

import com.practice.bmspractice.controllers.UserController;
import com.practice.bmspractice.dtos.UserSignUpRequestDto;
import com.practice.bmspractice.dtos.UserSignUpResponseDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BmsPracticeApplication implements CommandLineRunner {
    private final UserController userController;
    public BmsPracticeApplication(UserController userController) {
        this.userController = userController;
    }
    @Override
    public void run(String... args) throws Exception {
        UserSignUpRequestDto userSignUpRequestDto = new UserSignUpRequestDto();
        userSignUpRequestDto.setName("John Doe");
        userSignUpRequestDto.setEmail("johndoe@gmail.com");
        userSignUpRequestDto.setPassword("password123");
        userSignUpRequestDto.setPhoneNumber("1234567890");

        UserSignUpResponseDto userSignUpResponseDto = userController.signUp(userSignUpRequestDto);
        System.out.println("User signed up with ID: " + userSignUpResponseDto.getUserId());
    }

    public static void main(String[] args) {
		SpringApplication.run(BmsPracticeApplication.class, args);
	}

}
