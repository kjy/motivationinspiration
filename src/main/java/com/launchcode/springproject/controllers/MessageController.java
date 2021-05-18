package com.launchcode.springproject.controllers;

import com.launchcode.springproject.model.Message;
import com.launchcode.springproject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/list")  //list of users
    public String viewListMessages(Model model) {
        model.addAttribute("listMessages", messageService.getAllMessages());
        return "list";
    }

    @GetMapping("/showNewMessageForm")
    public String showNewMessageForm(Model model) {
        // create model attribute to bind from data
        Message message = new Message();
        model.addAttribute("message", message);
        return "new_message";
    }

    @PostMapping("/saveMessage")
    public String saveMessage(@ModelAttribute("message") Message message) {
        // save message to database
        messageService.saveMessage(message);
        return "redirect:/list";

    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model){
        // get message from the service
        Message message = messageService.getMessageById(id);

        // set message as a model attribute to pre-populate the form
        model.addAttribute("message", message);
        return "update_message";
    }


    @GetMapping("/deleteMessage/{id}")
    public String deleteMessage(@PathVariable(value = "id") Long id, Model model) {
        // call delete message method
        this.messageService.deleteMessageById(id);
        return "redirect:/list";
    }


}
