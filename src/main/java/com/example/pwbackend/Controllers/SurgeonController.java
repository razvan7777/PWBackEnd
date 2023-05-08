package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Bodies.SurgeonBody;
import com.example.pwbackend.Models.Entities.Surgeon;
import com.example.pwbackend.Services.SurgeonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surgeons")
@CrossOrigin(origins = "http://localhost:4200")
public class SurgeonController {

    @Autowired
    private SurgeonService surgeonService;


    @Operation(
            summary = "add a surgeon",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping
    public ResponseEntity<Surgeon> addSurgeon(@RequestBody Surgeon surgeon) {
        return new ResponseEntity<>(surgeonService.addSurgeon(surgeon), HttpStatus.OK);
    }

    @Operation(
            summary = "get a surgeon",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/{id}")
    public ResponseEntity<Surgeon> getSurgeon(@PathVariable Long id) {
        return new ResponseEntity<>(surgeonService.getSurgeon(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<SurgeonBody>> getSurgeons() {
        return new ResponseEntity<>(surgeonService.getSurgeons(), HttpStatus.OK);
    }

    @Operation(
            summary = "delete a surgeon",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSurgeon(@PathVariable Long id) {
        return new ResponseEntity<>(surgeonService.deleteSurgeon(id), HttpStatus.OK);
    }

    @Operation(
            summary = "update a surgeon",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateSurgeon(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}