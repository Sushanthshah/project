package com.group2.project.tasklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group2.project.tasklist.entity.ToDoApp;
import com.group2.project.tasklist.repository.ToDoAppRepository;

import java.util.List;

@Service
public class ToDoAppService {

    @Autowired
    private ToDoAppRepository repository;

    public List<ToDoApp> findAll() {
        return repository.findAll();
    }

    public ToDoApp save(ToDoApp todo) {
        return repository.save(todo);
    }

    public ToDoApp findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
