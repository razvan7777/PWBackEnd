package com.example.pwbackend.Repositories;

import com.example.pwbackend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public User getUserById(Long userId);

    public Optional<User> getUserByName(String name);
}
