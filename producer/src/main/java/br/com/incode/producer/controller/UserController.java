package br.com.incode.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.incode.producer.model.User;
import br.com.incode.producer.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user) {
        userService.sendMessage(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
