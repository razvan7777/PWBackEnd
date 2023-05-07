package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Entities.User;
import com.example.pwbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;

    public User getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null){
            user.setPassword(null);
        }

        return user;
    }

    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);

        User user = getUser(id);

        return user == null;

    }

}