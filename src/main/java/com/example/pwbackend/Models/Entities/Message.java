package com.example.pwbackend.Models.Entities;

import com.example.pwbackend.Models.Entities.Chat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chatId")
    private Chat chat;

    private String text;

    private Boolean sentBySurgeon;

    private Date dateTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateTimestamp() {
        return dateTimestamp;
    }

    public void setDateTimestamp(Date dateTimestamp) {
        this.dateTimestamp = dateTimestamp;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Boolean getSentBySurgeon() {
        return sentBySurgeon;
    }

    public void setSentBySurgeon(Boolean sentBySurgeon) {
        this.sentBySurgeon = sentBySurgeon;
    }

    public Long getChatId() {
        return chat.getId();
    }
}
