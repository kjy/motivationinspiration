package com.launchcode.springproject.model;

import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity   // This tells hibernate to make a table out of this class
@Table(name = "users", schema="motivationinspiration")
public class User {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="usermessage_id", referencedColumnName = "id")
    private List<Message> messages = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "users_id")
    private Long id;

//    @Column(name="email address", nullable = false, unique = true, length = 45)
    private String email;

//    @Column(name="cell phone number", nullable = false, unique = true, length = 45)
    private String cellphone;

//    @Column(name = "password", nullable = false, length = 64)
    private String password;

//    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

//    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;



    // empty constructor
    public User() { };

    public User(Long id, String email, String cellphone, String password, String firstName, String lastName) {
        super();
        this.id = id;
        this.email = email;
        this.cellphone = cellphone;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
