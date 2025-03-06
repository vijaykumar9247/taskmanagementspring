package com.example.taskmaneger.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmaneger.entity.Tasks;
import com.example.taskmaneger.payload.TaskDto;

public interface Tasrepo extends JpaRepository<Tasks, Long> {

	List<Tasks> findAllByUsersId(Long userId);


}
