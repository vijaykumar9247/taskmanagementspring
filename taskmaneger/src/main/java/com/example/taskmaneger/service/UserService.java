package com.example.taskmaneger.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.taskmaneger.payload.UserDto;
import com.example.taskmaneger.repo.Userrepo;
public interface UserService  {
public UserDto createuser(UserDto userdto);
}
