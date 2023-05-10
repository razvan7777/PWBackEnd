package com.example.pwbackend.Models.Bodies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageBody {
    private String text;
    private Long chatId;

    private Boolean sentBySurgeon;

}
