# motivationinspiration

### Overview
The motivation for this message tracking app came form the pandemic as a way to provide self-care to those experiencing hard times. This app provides a way for people to track and refer back to their own uplifting and positive messages as a way to motivate and inspire themselves to stay focused, to have a positive outlook, and to move forward in life.  The user will first register, allowing for login authentication. Next, the user will be able to view, create, modify and delete messages.   This app will allow the user to track their own messages for their own interest.  Another feature includes a gallery of images that have caption messages.  Finally, the app includes pulling and displaying weather data.  

### Demo Video - Four minutes

[demo](https://www.loom.com/share/ead76eeb323d476b9aceea999fc64c76)


### Features
Feature 1: Registration, login, hashed password, authentication            

Feature 2: Create, Read, Update, Delete (CRUD operations) for messages      

Feature 3: Gallery of images with caption messages                          

Feature 4: Pull weather data and display on website, using API            


### Technologies
Java programming language

Maven dependency management

Spring Boot/ Spring Framework

MySQL/MySQL workbench

Spring Data JPA (Hibernate)

Thymeleaf template

Rest Template for API call; parse out JSON and convert to Java object properties


### Application Architecture
Frontend: Thymeleaf template to render HTML, CSS, and bootstrap to browser

Backend:  Controller (View), Service (Business Logic), Repository (DAO-CRUD)

Database: MySQL


### Routes from Localhost:8080

/

/register

/process_register

/users

/login

/list

/showNewMessageForm

/ShowFormForUpdate/{id}

/deleteMessage/{id}

/gallery   

/temp      




