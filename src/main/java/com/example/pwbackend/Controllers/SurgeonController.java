package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Surgeon;
import com.example.pwbackend.Services.SurgeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/surgeons")
public class SurgeonController {

    @Autowired
    private SurgeonService surgeonService;

    @PostMapping
    public ResponseEntity<Boolean> addSurgeon(@RequestBody Surgeon surgeon) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Surgeon> getSurgeon(@PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSurgeon(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateSurgeon(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}