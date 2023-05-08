package com.example.pwbackend.Models.Bodies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBody {

    private String firstName;
    private String lastName;
    private String email;
}
