package com.example.taskmaneger.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmaneger.entity.Users;

@Repository
public interface Userrepo extends JpaRepository<Users, Long>{

}
