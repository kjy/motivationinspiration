package com.launchcode.springproject.service;

import com.launchcode.springproject.model.Message;


import java.util.List;


public interface MessageService {

    List<Message> getAllMessages();
    void saveMessage(Message message);
    Message getMessageById(Long id);
    void deleteMessageById(Long id);


}
