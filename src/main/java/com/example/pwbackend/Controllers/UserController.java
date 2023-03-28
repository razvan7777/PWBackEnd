package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.User;
import com.example.pwbackend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }


    @PostMapping("/validation")
    ResponseEntity<Boolean> checkTokenValidity(@RequestParam String token, @RequestParam Long userId) {
        return  userService.checkTokenValidity(token, userId);
    }

    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody User fe_input){
        return userService.login(fe_input);
    }


}
