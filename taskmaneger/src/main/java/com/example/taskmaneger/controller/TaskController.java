package com.example.taskmaneger.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.taskmaneger.payload.TaskDto;
import com.example.taskmaneger.service.TaskService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TaskController {
   @Autowired
	TaskService taskservice;
	//save task
	
	 @PostMapping("/{userid}/savetask")
	 public ResponseEntity<TaskDto> saveTask(@PathVariable Long userid,@RequestBody TaskDto taskdto) {
	 	//TODO: process POST request
		 System.out.println("hiteed");
	 	return new ResponseEntity<TaskDto>(taskservice.saveTask(userid, taskdto),HttpStatus.CREATED);
	 	
	 }
	 
	
	//get all task for particular userid
	 @GetMapping("/{userid}/tasks")
	 public ResponseEntity<List<TaskDto>>getalltasks(@PathVariable Long userid){
		 return new ResponseEntity<List<TaskDto>>(taskservice.getAllTasks(userid), HttpStatus.OK);
	 }
	
	
	//get specific task
	@GetMapping("/{userid}/gettaskspec/{taskid}")
	 public ResponseEntity<TaskDto> getspecifictask(@PathVariable Long userid,@PathVariable Long taskid){
		TaskDto taskDto = taskservice.getSpecificTask(userid, taskid);
	    return new ResponseEntity<>(taskDto, HttpStatus.OK);
	 }
	
	//delete task
	
	@DeleteMapping("/{userid}/del/{taskid}")
	public void deleteTask(@PathVariable Long userid,@PathVariable Long taskid) {
	 taskservice.deleteTask(userid, taskid);
	}
	
	
}
