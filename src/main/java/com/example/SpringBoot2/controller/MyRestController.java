package com.example.SpringBoot2.controller;

import com.example.SpringBoot2.forms.UserFormCreateApi;
import com.example.SpringBoot2.model.User;
import com.example.SpringBoot2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private final UserService userService;

    public MyRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.showAllUsers(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }





    @PostMapping()
    public UserFormCreateApi createNewUser(@RequestBody UserFormCreateApi user) {

        User newUser = User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .age(user.getAge())
                .password(user.getPassword())
                .build();

        newUser.setRoles(userService.findRolesByName(user.getRoles()));
        userService.saveUser(newUser);
        return user;
    }

    @PutMapping
    public UserFormCreateApi updateUser(@RequestBody UserFormCreateApi user) {
        User newUser = User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .age(user.getAge())
                .password(user.getPassword())
                .build();
        newUser.setRoles(userService.findRolesByName(user.getRoles()));
        userService.saveUser(newUser);
        return user;
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "OK";
    }
}
