package com.example.pwbackend.Controllers;


import com.example.pwbackend.Models.AuthenticationRequest;
import com.example.pwbackend.Models.AuthenticationResponse;
import com.example.pwbackend.Models.RegisterRequest;
import com.example.pwbackend.Services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @Operation(
          summary = "register an user"
  )
  @ApiResponses(value = {
          @ApiResponse(
                  responseCode = "201",
                  description = "User registered successfully"),
          @ApiResponse(
                  responseCode = "400",
                  description = "Something is wrong with the request")
  })
  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(authenticationService.register(request));
  }

  @Operation(
          summary = "authenticate an user"
  )
  @ApiResponses(value = {
          @ApiResponse(
                  responseCode = "200",
                  description = "User authenticated successfully"),
          @ApiResponse(
                  responseCode = "400",
                  description = "Something is wrong with the request")
  })
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(authenticationService.authenticate(request));
  }

}
