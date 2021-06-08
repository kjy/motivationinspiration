package com.launchcode.springproject.model;

// create a domain model, JPA entity

import javax.persistence.*;

@Entity
@Table(name="messages", schema="motivationinspiration")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String text;

    public Message() { };

    public Message(Long id, String email, String text) {
        super();
        this.id = id;
        this.email = email;
        this.text = text;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
