package com.example.pwbackend.Repositories;

import com.example.pwbackend.Models.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
