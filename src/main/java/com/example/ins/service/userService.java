package com.example.ins.service;

import com.example.ins.entity.users;
import com.example.ins.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    private userRepository uRepository;

    public users addUser(users u){return uRepository.save(u);}
    public List<users> addUsers(List<users> users){return uRepository.saveAll(users);}
    public List<users> getUsers(){return uRepository.findAll();}




}
