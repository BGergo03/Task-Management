package com.taskmanagement.services;

import com.taskmanagement.dtos.TaskDto;
import com.taskmanagement.models.Task;

import java.util.List;

public interface TaskService {

    Task getTaskById(long id);

    List<Task> getTasks();

    Task addTask(TaskDto taskDto);

    Task deleteTaskById(long id);

    Task getTaskByTitle(String title);
}
