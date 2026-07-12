package com.example.training.taskmanagerms.application.port.in;

import com.example.training.taskmanagerms.domain.model.Task;
import java.util.List;

public interface ListTasksUseCase {
    List<Task> listTasks();
}