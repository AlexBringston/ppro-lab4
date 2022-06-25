package com.ua.pprolab4.services;

import com.ua.pprolab4.models.Message;
import com.ua.pprolab4.repositories.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message findMessageById(Long id) {
        return messageRepository.findById(id).orElse(new Message());
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
