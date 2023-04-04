package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Invoice;
import com.example.pwbackend.Models.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @PostMapping
    public ResponseEntity<Boolean> addMessage(@RequestBody Message message) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getMessage(@PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteMessage(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateMessage(@PathVariable Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
