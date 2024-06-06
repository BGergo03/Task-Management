package com.example.taskmanagement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "tasks")
public class TaskController {

    @GetMapping
    public List<String> getTasks() {
        return List.of("Task 1", "Task 2", "Task 3", "Task 4", "Task 5");
    }
}
