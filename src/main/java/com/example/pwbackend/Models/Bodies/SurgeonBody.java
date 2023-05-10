package com.example.pwbackend.Models.Bodies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurgeonBody {

    private Long id;

    private UserBody userBody;
    private String title;
    private String description;
    private Long rating;

}
