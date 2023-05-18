package com.example.pwbackend.Services;

import com.example.pwbackend.Models.Bodies.MessageBody;
import com.example.pwbackend.Models.Entities.Chat;
import com.example.pwbackend.Models.Entities.Document;
import com.example.pwbackend.Models.Entities.Message;
import com.example.pwbackend.Repositories.ChatRepository;
import com.example.pwbackend.Repositories.DocumentRepository;
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
    @Autowired
    private DocumentRepository documentRepository;

    public List<MessageBody> getMessages(Long chatId)
    {
        Chat chat = chatRepository.findById(chatId).orElse(null);

        if (chat == null)
            return null;

        List<Message> messages = chat.getMessages();

        List<MessageBody> messageBodies = new ArrayList<>();

        messages.forEach(message -> {
            if (message.getDocument() != null) {
                messageBodies.add(new MessageBody(
                        message.getChatId(),
                        message.getDocument().getId(),
                        message.getDocument().getFileName(),
                        message.getSentBySurgeon()
                ));
            }
            else
            {
                messageBodies.add(new MessageBody(
                        message.getChatId(),
                        null,
                        message.getText(),
                        message.getSentBySurgeon()
                ));
            }
        });

        return messageBodies;

    }

    public MessageBody addMessage(MessageBody messageBody)
    {
        Message message = new Message();

        message.setChat(chatRepository.findById(messageBody.getChatId()).orElse(null));
        message.setText(messageBody.getText());
        message.setSentBySurgeon(messageBody.getSentBySurgeon());
        message.setDateTimestamp(new Date());

        if (messageBody.getDocId() != null)
            message.setDocument(documentRepository.findById(messageBody.getDocId()).orElse(null));

        Message savedMessage = messageRepository.save(message);

        if(savedMessage.getDocument() != null)
            return new MessageBody(
                    savedMessage.getChatId(),
                    savedMessage.getDocument().getId(),
                    savedMessage.getDocument().getFileName(),
                    savedMessage.getSentBySurgeon()
            );
        else
            return new MessageBody(
              savedMessage.getChatId(),
              null,
              savedMessage.getText(),
              savedMessage.getSentBySurgeon()
            );
    }
}
