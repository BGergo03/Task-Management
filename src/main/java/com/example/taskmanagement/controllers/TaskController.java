package com.example.taskmanagement.controllers;

import com.example.taskmanagement.dtos.TaskDto;
import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody TaskDto taskDto) {
        return taskService.addTask(taskDto);
    }

    @DeleteMapping
    public void deleteTask(@RequestParam long id) {
        taskService.deleteTaskById(id);
    }
}
