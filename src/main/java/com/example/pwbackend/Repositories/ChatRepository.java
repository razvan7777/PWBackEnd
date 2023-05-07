package com.example.pwbackend.Repositories;

import com.example.pwbackend.Models.Entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat,Long> {
}
