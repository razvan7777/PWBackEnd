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
    private Long chatId;

    private Long docId;

    private String text;

    private Boolean sentBySurgeon;


}
