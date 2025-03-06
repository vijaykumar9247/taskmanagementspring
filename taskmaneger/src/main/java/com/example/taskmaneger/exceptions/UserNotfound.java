package com.example.taskmaneger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotfound extends RuntimeException{
 String msg;
	public UserNotfound(String msg){
		super(msg);
	}
	
}
