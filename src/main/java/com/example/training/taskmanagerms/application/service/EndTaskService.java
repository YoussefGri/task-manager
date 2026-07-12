package com.example.training.taskmanagerms.application.service;

import com.example.training.taskmanagerms.application.port.in.EndTaskUseCase;
import com.example.training.taskmanagerms.application.port.out.TaskRepository;
import com.example.training.taskmanagerms.domain.exception.TaskNotFoundException;
import com.example.training.taskmanagerms.domain.model.Task;

import java.util.UUID;

public class EndTaskService implements EndTaskUseCase{

    private final TaskRepository taskRepository;

    public EndTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task endTask(UUID id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.end();
        return taskRepository.save(task);
    }
}
