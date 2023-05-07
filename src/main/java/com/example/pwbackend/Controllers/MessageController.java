package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Bodies.MessageBody;
import com.example.pwbackend.Models.Entities.Message;
import com.example.pwbackend.Services.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Operation(
            summary = "add an message",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping
    public ResponseEntity<Message> addMessage(@RequestBody MessageBody messageBody) {
        return new ResponseEntity<>(messageService.addMessage(messageBody), HttpStatus.OK);
    }

    @GetMapping("/{chatId}")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Long chatId) {
        return new ResponseEntity<>(messageService.getMessages(chatId), HttpStatus.OK);
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
