package com.group2.project.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.group2.project.tasklist.entity.ToDoApp;

public interface ToDoAppRepository extends JpaRepository<ToDoApp, Long> {
}
