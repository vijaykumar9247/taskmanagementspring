package com.example.taskmaneger.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.taskmaneger.entity.Tasks;
import com.example.taskmaneger.entity.Users;
import com.example.taskmaneger.exceptions.TasksNotFound;
import com.example.taskmaneger.exceptions.UserNotfound;
import com.example.taskmaneger.payload.TaskDto;
import com.example.taskmaneger.repo.Tasrepo;
import com.example.taskmaneger.repo.Userrepo;
import com.example.taskmaneger.service.TaskService;

@Service
public class TaskServiceimpl implements TaskService{
     @Autowired
	Tasrepo taskrepo;
     @Autowired
       ModelMapper modelMapper;
     @Autowired
     Userrepo userrepo;
	
	@Override
	public TaskDto saveTask(Long userid,TaskDto taskdto) {
		Users saveduser= userrepo.findById(userid).orElseThrow(
				()->new TasksNotFound("no tasks for userr")
				);
	 Tasks task=	modelMapper.map(taskdto, Tasks.class);
	  task.setUsers(saveduser);
	  Tasks savedtasks=taskrepo.save(task);
	   return modelMapper.map(savedtasks, TaskDto.class);
	 
	}

	@Override
	public List<TaskDto> getAllTasks(Long userid) {
		
		userrepo.findById(userid).orElseThrow(
				()->new UserNotfound("user not foundd")
				);
		
		List<Tasks> allByUserid = taskrepo.findAllByUsersId(userid);
		allByUserid.stream().forEach(task->{
			System.out.println(task.getTaskname()+"   "+task.getId());
		});
		return allByUserid.stream().map(task->modelMapper.map(task, TaskDto.class)).collect(Collectors.toList());
		
		
	}

	@Override
	public TaskDto getSpecificTask(Long userid, Long taskid) {
		 Users user = userrepo.findById(userid).orElseThrow(
				 ()->new UserNotfound("user not found")
				 );
		 
		Tasks task= taskrepo.findById(taskid).orElseThrow(
				 ()->new TasksNotFound("task not found plzz check another one")
				 );
		 
		 if(user.getId()!=task.getUsers().getId()) {
			 throw new TasksNotFound("not found");
		 }
		 System.out.println(userid+"------------------"+taskid);
	
		  TaskDto taskDto = modelMapper.map(task, TaskDto.class);

	       
	       return taskDto;
		
	}

	@Override
	public void deleteTask(Long userid,Long taskid) {
		 Users user = userrepo.findById(userid).orElseThrow(
				 ()->new UserNotfound("user not found")
				 );
		 
		Tasks task= taskrepo.findById(taskid).orElseThrow(
				 ()->new TasksNotFound("task not found plzz check another one")
				 );
		 
		 if(user.getId()!=task.getUsers().getId()) {
			 throw new TasksNotFound("not found");
		 }
		 
		taskrepo.deleteById(taskid);
		
	}


	

}
