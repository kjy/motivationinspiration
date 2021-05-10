package com.launchcode.springproject.service;

import com.launchcode.springproject.model.Message;
import com.launchcode.springproject.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public void saveMessage(Message message) {
        this.messageRepository.save(message);

    }

    @Override
    public Message getMessageById(Long id) {
        Optional<Message> optional = messageRepository.findById(id);
        Message message = null;
        if (optional.isPresent()) {
            message = optional.get();
        } else {
            throw new RuntimeException(" Message not found for id :: " + id);
        }
        return message;
    }

    @Override
    public void deleteMessageById(Long id) {
        this.messageRepository.deleteById(id);

    }

}
