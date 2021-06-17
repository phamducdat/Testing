package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserRepository repository;

    @PostMapping
    @Transactional
    @ResponseBody
    public User save(@RequestBody @Valid UserInput user) {
        return repository.saveAndFlush(new User(
                null,
                user.getLastName(),
                user.getMiddleName(),
                user.getFirstName(),
                null,
                user.getSiblings()));
    }


}