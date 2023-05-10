package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Bodies.UserBody;
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

    public UserBody getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null){
            return null;
        }

        return new UserBody(
                user.getId(),
                user.getRole(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getImageUrl()
        );
    }

    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);

        User user = userRepository.findById(id).orElse(null);

        return user == null;

    }

}