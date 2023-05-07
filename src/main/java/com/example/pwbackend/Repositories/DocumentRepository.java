package com.example.pwbackend.Repositories;

import com.example.pwbackend.Models.Entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}
