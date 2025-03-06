package com.example.taskmaneger.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Tasks {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
@Column(nullable = false)
private String taskname;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTaskname() {
	return taskname;
}

public void setTaskname(String taskname) {
	this.taskname = taskname;
}

@ManyToOne
@JoinColumn(name = "usersid")
private Users users;

public Users getUsers() {
	return users;
}

public void setUsers(Users users) {
	this.users = users;
}
}
