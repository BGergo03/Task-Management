package com.example.taskmanagement.services;

import com.example.taskmanagement.dtos.TaskDto;
import com.example.taskmanagement.models.Task;

import java.util.List;

public interface TaskService {

    Task getTaskById(long id);

    List<Task> getTasks();

    Task addTask(TaskDto taskDto);

    Task deleteTaskById(long id);
}
