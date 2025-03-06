package com.example.taskmaneger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmaneger.payload.UserDto;
import com.example.taskmaneger.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	UserService userservice;
    @PostMapping(value="/register")
	public ResponseEntity<UserDto> createuser(@RequestBody UserDto ud) {
		return new ResponseEntity<UserDto>( userservice.createuser(ud),HttpStatus.CREATED);
		
	}
}
