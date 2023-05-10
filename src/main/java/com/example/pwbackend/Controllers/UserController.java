package com.example.pwbackend.Controllers;

import com.example.pwbackend.Models.Bodies.UserBody;
import com.example.pwbackend.Models.Entities.User;
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

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
        summary = "get an user",
        security = @SecurityRequirement(name = "bearerAuth"),
        responses = {
            @ApiResponse(responseCode = "200", description = "user got successfully"),
            @ApiResponse(responseCode = "404", description = "user not found", content = @Content())
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserBody> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @Operation(
        summary = "delete an user",
        security = @SecurityRequirement(name = "bearerAuth"),
        responses = {
            @ApiResponse(responseCode = "204", description = "user deleted successfully"),
            @ApiResponse(responseCode = "400", description = "user not deleted", content = @Content(examples = @ExampleObject(value = "false")))
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

    @Operation(
        summary = "update an user",
        security = @SecurityRequirement(name = "bearerAuth"),
        responses = {
            @ApiResponse(responseCode = "200", description = "user updated successfully"),
            @ApiResponse(responseCode = "400", description = "user not updated", content = @Content())
        }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateUser(@RequestBody UserBody userBody) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
