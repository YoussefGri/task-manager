package com.example.training.taskmanagerms.application.port.in;

import java.util.UUID;

public interface DeleteTaskUseCase {
    void deleteTask(UUID id);
}