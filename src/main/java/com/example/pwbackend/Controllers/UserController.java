package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.User;
import com.example.pwbackend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Boolean> addUser(@RequestBody User user) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateUser(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
