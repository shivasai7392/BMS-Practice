package com.practice.bmspractice.service;

import com.practice.bmspractice.models.User;
import com.practice.bmspractice.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User signUp(String username, String password, String email){
        User user = new User();
        user.setName(username);

        // Encode the password before saving (omitted for brevity)
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        user.setEmail(email);
        // Logic to save user to database would go here
        return userRepository.save(user);
    }
}
