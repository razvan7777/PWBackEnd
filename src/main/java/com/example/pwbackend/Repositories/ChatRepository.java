package com.example.pwbackend.Repositories;

import com.example.pwbackend.Models.Entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Long> {
    @Query(value = "SELECT * FROM chat WHERE user1_id = :userId OR user2_id = :userId", nativeQuery = true)
    List<Chat> findAllByUserId(Long userId);

    @Query(value = "SELECT * FROM chat WHERE (user1_id = :user1Id AND user2_id = :user2Id) OR (user1_id = :user2Id AND user2_id = :user1Id)", nativeQuery = true)
    Chat findByUser1IdAndUser2Id(Long user1Id, Long user2Id);
}
