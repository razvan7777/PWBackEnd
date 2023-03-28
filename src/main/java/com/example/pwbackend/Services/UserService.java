package com.example.pwbackend.Services;

import com.example.pwbackend.JwtTokenUtil;
import com.example.pwbackend.Models.User;
import com.example.pwbackend.Repositories.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public ResponseEntity<String> login(User fe_input) {
        try {
            // get the database user based on frontend input
            Optional<User> database_user = userRepository.getUserByName(fe_input.getName());

            if ( database_user.isEmpty() ) {
                // user was not found in database
                return new ResponseEntity<>(new JSONObject().put("token", "none").toString(), HttpStatus.UNAUTHORIZED);
            } else if ( ! database_user.get().getPassword().equals(fe_input.getPassword())) {
                // password in database does not match frontend input
                return new ResponseEntity<>(new JSONObject().put("token", "none").toString(), HttpStatus.UNAUTHORIZED);
            } else {
                // password in database matches frontend input
                String token = jwtTokenUtil.generateToken(fe_input);

                return new ResponseEntity<>(new JSONObject()
                        .put("token", token)
                        .put("userId", userRepository.getUserByName(fe_input.getName()).get().getId()).toString(),
                        HttpStatus.OK);
            }

        }
        catch(Exception e){

            System.out.println(e.getMessage());
            return new ResponseEntity<>(new JSONObject().put("token", "none").toString(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    public ResponseEntity<Boolean> checkTokenValidity(String token, Long userId) {

        try {
            return new ResponseEntity<>(jwtTokenUtil.validateToken(token, userRepository.getUserById(userId)), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}