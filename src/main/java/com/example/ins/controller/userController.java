package com.example.ins.controller;

import com.example.ins.entity.users;
import com.example.ins.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class userController {
    @Autowired
    private userService uService;

    @PostMapping("/addUser")
    public users addUser(@RequestBody users u){
        return uService.addUser(u);}
    @PostMapping("/addUsers")
    public List<users> addUsers(@RequestBody List<users> users){
        return uService.addUsers(users);}
    @GetMapping("/users")
    public List<users> getUsers(){return uService.getUsers();}
}
