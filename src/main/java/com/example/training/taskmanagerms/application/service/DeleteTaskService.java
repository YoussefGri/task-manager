package com.example.training.taskmanagerms.application.service;

import com.example.training.taskmanagerms.application.port.in.DeleteTaskUseCase;
import com.example.training.taskmanagerms.application.port.out.TaskRepository;
import com.example.training.taskmanagerms.domain.exception.TaskNotFoundException;
import java.util.UUID;

public class DeleteTaskService implements DeleteTaskUseCase {

    private final TaskRepository taskRepository;

    public DeleteTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void deleteTask(UUID id) {
        if (taskRepository.findById(id).isEmpty()) {
            throw new TaskNotFoundException("Task not found");
        }
        taskRepository.deleteById(id);
    }
}