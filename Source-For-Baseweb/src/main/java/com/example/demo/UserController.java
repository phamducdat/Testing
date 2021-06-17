package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
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
                user.getDateOfBirth(),
                user.getSiblings()));
    }


}