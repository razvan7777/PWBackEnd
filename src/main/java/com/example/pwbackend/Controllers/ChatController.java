package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Entities.Chat;
import com.example.pwbackend.Models.Bodies.ChatBody;
import com.example.pwbackend.Services.ChatService;
import com.example.pwbackend.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private UserService userService;

    @Operation(
            summary = "add an chat",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping
    public ResponseEntity<Chat> addChat(@RequestBody ChatBody chatBody) {

        return new ResponseEntity<>(chatService.addChat(chatBody), HttpStatus.OK);
    }
}
