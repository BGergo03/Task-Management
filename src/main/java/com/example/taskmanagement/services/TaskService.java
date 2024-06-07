package com.example.taskmanagement.services;

import com.example.taskmanagement.dtos.CreateTask;
import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    // todo: date provider

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(CreateTask createTask) {
        Task newTask = new Task(
                createTask.getTitle(),
                createTask.getDescription());
        return taskRepository.save(newTask);
    }

}
