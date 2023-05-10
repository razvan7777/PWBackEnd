package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Bodies.MessageBody;
import com.example.pwbackend.Models.Entities.Message;
import com.example.pwbackend.Services.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "message created successfully"),
                    @ApiResponse(responseCode = "400", description = "message not created", content = @Content())
            }
    )
    @PostMapping
    public ResponseEntity<MessageBody> addMessage(@RequestBody MessageBody messageBody) {
        return new ResponseEntity<>(messageService.addMessage(messageBody), HttpStatus.OK);
    }

    @Operation(
            summary = "get messages from chat",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "message got successfully"),
                    @ApiResponse(responseCode = "404", description = "message not found", content = @Content())
            }
    )
    @GetMapping("/{chatId}")
    public ResponseEntity<List<MessageBody>> getMessages(@PathVariable Long chatId) {
        return new ResponseEntity<>(messageService.getMessages(chatId), HttpStatus.OK);
    }

//    @Operation(
//            summary = "delete messages from chat",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @DeleteMapping("/{chatId}")
//    public ResponseEntity<Boolean> deleteMessages(@PathVariable Long id) {
//        return new ResponseEntity<>(true, HttpStatus.OK);
//    }

//    @Operation(
//            summary = "update an message",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PutMapping("/{id}")
//    public ResponseEntity<Boolean> updateMessage(@PathVariable Long id) {
//        return new ResponseEntity<>(true, HttpStatus.OK);
//    }

}
