package com.example.training.taskmanagerms.application.port.in;

import com.example.training.taskmanagerms.domain.model.Task;

import java.util.UUID;

public interface EndTaskUseCase {
    Task endTask(UUID id);
}
