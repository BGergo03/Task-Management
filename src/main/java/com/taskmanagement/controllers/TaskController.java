package com.taskmanagement.controllers;

import com.taskmanagement.dtos.TaskDto;
import com.taskmanagement.models.Task;
import com.taskmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") long id) {
        Task result = taskService.getTaskById(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/title/{title}")
    public ResponseEntity<Task> getTaskByTitle(@PathVariable("title") String title) {
        Task result = taskService.getTaskByTitle(title);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody TaskDto taskDto) {
        return taskService.addTask(taskDto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        Task deletedTask = taskService.deleteTaskById(id);
        if (deletedTask == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
