package com.example.taskmanagement.services;

import com.example.taskmanagement.dtos.TaskDto;
import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final DateProvider dateProvider;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, DateProvider dateProvider) {
        this.taskRepository = taskRepository;
        this.dateProvider = dateProvider;
    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task getTaskByTitle(String title) {
        return taskRepository.findByTitle(title).orElse(null);
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task addTask(TaskDto taskDto) {
        Task newTask = new Task();
        newTask.setTitle(taskDto.getTitle());
        newTask.setDescription(taskDto.getDescription());
        newTask.setCreatedAt(dateProvider.getCurrentDate());
        return taskRepository.save(newTask);
    }

    @Override
    public Task deleteTaskById(long id) {
        Task taskToBeDeleted = taskRepository.findById(id).orElse(null);
        if (taskToBeDeleted != null) {
            taskRepository.deleteById(id);
        }
        return taskToBeDeleted;
    }

}
