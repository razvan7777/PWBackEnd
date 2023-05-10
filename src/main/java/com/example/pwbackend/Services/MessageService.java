package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Bodies.MessageBody;
import com.example.pwbackend.Models.Entities.Chat;
import com.example.pwbackend.Models.Entities.Message;
import com.example.pwbackend.Repositories.ChatRepository;
import com.example.pwbackend.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatRepository chatRepository;

    public List<MessageBody> getMessages(Long chatId)
    {
        Chat chat = chatRepository.findById(chatId).orElse(null);

        if (chat == null)
            return null;

        List<Message> messages = chat.getMessages();

        List<MessageBody> messageBodies = new ArrayList<>();

        messages.forEach(message -> {
            messageBodies.add(new MessageBody(
                    message.getText(),
                    message.getChatId(),
                    message.getSentBySurgeon()
            ));
        });

        return messageBodies;

    }

    public MessageBody addMessage(MessageBody messageBody)
    {
        Message message = new Message();

        message.setChat(chatRepository.findById(messageBody.getChatId()).orElse(null));
        message.setText(messageBody.getText());
        message.setDateTimestamp(new Date());

        Message savedMessage = messageRepository.save(message);

        return new MessageBody(
                savedMessage.getText(),
                savedMessage.getChatId(),
                savedMessage.getSentBySurgeon()
        );
    }
}
