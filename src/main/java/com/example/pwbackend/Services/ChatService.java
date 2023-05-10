package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Entities.Appointment;
import com.example.pwbackend.Models.Entities.Chat;
import com.example.pwbackend.Models.Bodies.ChatBody;
import com.example.pwbackend.Repositories.ChatRepository;
import com.example.pwbackend.Repositories.SurgeonRepository;
import com.example.pwbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SurgeonRepository surgeonRepository;


    public ChatBody addChat(ChatBody chatBody)
    {
        Chat chat = new Chat();

        chat.setUser1(userRepository.findById(chatBody.getUser1Id()).orElse(null));
        chat.setUser2(userRepository.findById(chatBody.getUser2Id()).orElse(null));

        if (chat.getUser1() == null || chat.getUser2() == null)
        {
            return null;
        }

        List<Chat> chats = chatRepository.findAllByUserId(chat.getUser1().getId());


        for (Chat c : chats)
        {
            if( Objects.equals(c.getUser2().getId(), chat.getUser2().getId()) ||
                Objects.equals(c.getUser1().getId(), chat.getUser2().getId()))
            {
                return null;
            }
        }

        Chat chatSaved = chatRepository.save(chat);

        return new ChatBody(
            chatSaved.getId(),
            chatSaved.getUser1().getId(),
            chatSaved.getUser2().getId()
        );
    }

    public List<ChatBody> getChatsByUserId(Long userId) {

        List<Chat> chats = chatRepository.findAllByUserId(userId);

        List<ChatBody> chatBodies = new ArrayList<>();

        chats.forEach(chat -> {
            chatBodies.add(new ChatBody(
                chat.getId(),
                chat.getUser1().getId(),
                chat.getUser2().getId()
            ));
        });

        return chatBodies;
    }

    public ChatBody getChat(Long user1Id, Long user2Id)
    {
        Chat chat = chatRepository.findByUser1IdAndUser2Id(user1Id, user2Id);

        if (chat == null)
            return null;

        return new ChatBody(
                chat.getId(),
                chat.getUser1().getId(),
                chat.getUser2().getId()
        );

    }

    public Boolean deleteChat(Long id)
    {
        chatRepository.deleteById(id);

        Chat chat = chatRepository.findById(id).orElse(null);

        return chat == null;
    }
}