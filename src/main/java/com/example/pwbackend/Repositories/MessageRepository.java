package com.example.pwbackend.Repositories;

import com.example.pwbackend.Models.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface MessageRepository extends JpaRepository<Message,Long> {

}
