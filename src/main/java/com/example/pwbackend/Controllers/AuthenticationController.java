package com.example.pwbackend.Controllers;


import com.example.pwbackend.Models.AuthenticationRequest;
import com.example.pwbackend.Models.AuthenticationResponse;
import com.example.pwbackend.Models.RegisterRequest;
import com.example.pwbackend.Services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @Operation(
          summary = "register an user",
          description =
                  """
                  Register an User
                  
                  __Usage:__ localhost:8080/auth/register
                  """
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
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(authenticationService.authenticate(request));
  }


}
