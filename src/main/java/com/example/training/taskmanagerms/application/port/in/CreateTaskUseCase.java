package com.example.training.taskmanagerms.application.port.in;

import com.example.training.taskmanagerms.domain.model.Task;

public interface CreateTaskUseCase {
    Task createTask(String title, String deadline);
}
