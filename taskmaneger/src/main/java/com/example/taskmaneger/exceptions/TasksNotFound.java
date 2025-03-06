package com.example.taskmaneger.exceptions;

public class TasksNotFound extends RuntimeException{

	String msg;
	
	public TasksNotFound(String msg) {
		super(msg);
	}
}
