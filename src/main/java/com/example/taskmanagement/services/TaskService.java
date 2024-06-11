package com.example.taskmanagement.services;

import com.example.taskmanagement.dtos.TaskDto;
import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final DateProvider dateProvider;

    @Autowired
    public TaskService(TaskRepository taskRepository, DateProvider dateProvider) {
        this.taskRepository = taskRepository;
        this.dateProvider = dateProvider;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(TaskDto taskDto) {
        Task newTask = new Task();
        newTask.setTitle(taskDto.getTitle());
        newTask.setDescription(taskDto.getDescription());
        newTask.setCreatedAt(dateProvider.getCurrentDate());
        return taskRepository.save(newTask);
    }

    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }

}
