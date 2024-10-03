package com.example.login.controller;

import com.example.login.model.User;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String Email_Address, @RequestParam String Password) {
        Optional<User> user = userService.getUserByEmail(Email_Address);

        if (user.isPresent()) {
            if (user.get().getPassword().equals(Password)) {
                return "Login successful!";
            } else {
                return "Invalid email or password.";
            }
        } else {
            return "Invalid email or password.";
        }
    }
}
