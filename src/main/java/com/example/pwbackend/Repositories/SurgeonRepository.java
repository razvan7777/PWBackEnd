package com.example.pwbackend.Repositories;

import com.example.pwbackend.Models.Surgeon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeonRepository extends JpaRepository<Surgeon,Long> {
}
