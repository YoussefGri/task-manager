package com.example.training.taskmanagerms.application.service;

import com.example.training.taskmanagerms.application.port.in.ListTasksUseCase;
import com.example.training.taskmanagerms.application.port.out.TaskRepository;
import com.example.training.taskmanagerms.domain.model.Task;
import java.util.List;

public class ListTasksService implements ListTasksUseCase {

    private final TaskRepository taskRepository;

    public ListTasksService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll();
    }
}