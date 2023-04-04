package com.example.pwbackend.Repositories;

import com.example.pwbackend.Models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo extends JpaRepository<Document,Long> {
}
