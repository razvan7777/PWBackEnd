package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Entities.Appointment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @PostMapping("/{surgeon_id}/{user_id}")
    public ResponseEntity<Boolean> addAppointment(@RequestBody Appointment appointment, @PathVariable Long user_id, @PathVariable Long surgeon_id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAppointment(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateAppointment(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
