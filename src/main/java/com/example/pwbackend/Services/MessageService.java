package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Bodies.MessageBody;
import com.example.pwbackend.Models.Entities.Chat;
import com.example.pwbackend.Models.Entities.Message;
import com.example.pwbackend.Repositories.ChatRepository;
import com.example.pwbackend.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatRepository chatRepository;

    public List<Message> getMessages(Long chatId)
    {
        Chat chat = chatRepository.findById(chatId).orElse(null);

        if (chat == null)
            return null;

        return chat.getMessages();
    }

    public Message addMessage(MessageBody messageBody)
    {
        Message message = new Message();

        message.setChat(chatRepository.findById(messageBody.getChatId()).orElse(null));
        message.setText(messageBody.getText());
        message.setTimestamp(new Date());

        return messageRepository.save(message);
    }
}
