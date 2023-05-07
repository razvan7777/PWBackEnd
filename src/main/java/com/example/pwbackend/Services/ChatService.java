package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Entities.Chat;
import com.example.pwbackend.Models.Bodies.ChatBody;
import com.example.pwbackend.Repositories.ChatRepository;
import com.example.pwbackend.Repositories.SurgeonRepository;
import com.example.pwbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SurgeonRepository surgeonRepository;


    public Chat addChat(ChatBody chatBody)
    {
        Chat chat = new Chat();

        chat.setUser(userRepository.findById(chatBody.getUserId()).orElse(null));
        chat.setSurgeon(surgeonRepository.findById(chatBody.getSurgeonId()).orElse(null));

        return chatRepository.save(chat);
    }
}
