package com.example.pwbackend.Models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

@Entity
@ApiModel
@ToString
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private Surgeon surgeon;

    @OneToMany(mappedBy = "chat")
    List<Message> messages;

    public Long getSurgeonId()
    {
        return surgeon.getId();
    }

    public Long getUserId()
    {
        return user.getId();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Surgeon getSurgeon() {
        return surgeon;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSurgeon(Surgeon surgeon) {
        this.surgeon = surgeon;
    }

    @JsonIgnore
    public List<Message> getMessages() {
        return messages;
    }
}
