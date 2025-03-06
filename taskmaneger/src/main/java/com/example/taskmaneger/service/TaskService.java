package com.example.taskmaneger.service;

import java.util.List;

import com.example.taskmaneger.payload.TaskDto;
import com.example.taskmaneger.repo.Tasrepo;

public interface TaskService{
	// for gettting all tasks 
public List<TaskDto> getAllTasks(Long userid);
// for savingtasks for a particular user
public TaskDto saveTask(Long userid,TaskDto taskdto);
// for get specifi task
public TaskDto getSpecificTask(Long userid,Long taskid);

public void deleteTask(Long userid,Long taskid);
}
