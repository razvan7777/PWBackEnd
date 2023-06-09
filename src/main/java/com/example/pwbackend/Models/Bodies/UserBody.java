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
public class UserBody {

    private Long id;
    private Role role;
    private String firstName;
    private String lastName;
    private String email;
    private String imageUrl;

}
