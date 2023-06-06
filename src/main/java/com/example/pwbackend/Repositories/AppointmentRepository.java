package com.example.pwbackend.Repositories;

import com.example.pwbackend.Models.Entities.Appointment;
import com.example.pwbackend.Models.Entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    @Query(value = "SELECT * FROM appointment WHERE surgeon_id = :surgeonId", nativeQuery = true)
    Optional<List<Appointment>> findBySurgeonId(Long surgeonId);

    @Query(value = "SELECT * FROM appointment WHERE user_id = :userId", nativeQuery = true)
    Optional<List<Appointment>> findByUserId(Long userId);

}
