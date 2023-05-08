package com.example.pwbackend.Models.Bodies;



import com.example.pwbackend.Models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String password;
  private Role role;
}
