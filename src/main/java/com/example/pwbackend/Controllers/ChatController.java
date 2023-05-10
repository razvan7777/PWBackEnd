package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Bodies.ChatBody;
import com.example.pwbackend.Services.ChatService;
import com.example.pwbackend.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private UserService userService;

    @Operation(
            summary = "add an chat",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                @ApiResponse(responseCode = "201", description = "chat created successfully"),
                @ApiResponse(responseCode = "400", description = "chat not created", content = @Content())
            }
    )
    @PostMapping
    public ResponseEntity<ChatBody> addChat(@RequestBody ChatBody chatBody)
    {
        return new ResponseEntity<>(chatService.addChat(chatBody), HttpStatus.OK);
    }

    @Operation(
            summary = "get all chats of an user",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "chats got successfully"),
                    @ApiResponse(responseCode = "404", description = "chats not found", content = @Content())
            }
    )
    @GetMapping("/{userId}")
    public ResponseEntity<List<ChatBody>> getChatsByUserId(@PathVariable Long userId) {

        return new ResponseEntity<>(chatService.getChatsByUserId(userId), HttpStatus.OK);
    }

    @Operation(
            summary = "gets an chat specified by two users",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "chat got successfully"),
                    @ApiResponse(responseCode = "404", description = "chat not found", content = @Content())
            }
    )
    @GetMapping("/{user1Id}/{user2Id}")
    public ResponseEntity<ChatBody> getChat(@PathVariable Long user1Id, @PathVariable Long user2Id) {
        ChatBody chatBody = chatService.getChat(user1Id, user2Id);
        if ( chatBody != null)
        {
            return new ResponseEntity<>(chatBody, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "delete an chat",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "204", description = "chat deleted successfully"),
                    @ApiResponse(responseCode = "400", description = "chat not deleted", content = @Content(examples = @ExampleObject(value = "false")))
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteChat(@PathVariable Long id) {
        Boolean result = chatService.deleteChat(id);
        if (result)
        {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
        }
    }
}
