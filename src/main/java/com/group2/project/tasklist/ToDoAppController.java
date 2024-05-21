package com.group2.project.tasklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group2.project.tasklist.entity.ToDoApp;
import com.group2.project.tasklist.service.ToDoAppService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoAppController {

    @Autowired
    private ToDoAppService service;

    @GetMapping
    public List<ToDoApp> getAllToDos() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<ToDoApp> createToDo(@RequestBody ToDoApp todo) {
        ToDoApp createdTodo = service.save(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoApp> getToDoById(@PathVariable Long id) {
        ToDoApp todo = service.findById(id);
        return todo != null ? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
