package com.example.training.taskmanagerms.application.service;

import com.example.training.taskmanagerms.application.port.in.CreateTaskUseCase;
import com.example.training.taskmanagerms.application.port.out.TaskRepository;
import com.example.training.taskmanagerms.domain.model.DeadLine;
import com.example.training.taskmanagerms.domain.model.Task;
import com.example.training.taskmanagerms.domain.model.Title;
import java.time.LocalDate;

public class CreateTaskService implements CreateTaskUseCase {

    private TaskRepository taskRepository;

    public CreateTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String title, String deadLine) {

        LocalDate localDate = LocalDate.parse(deadLine);
        DeadLine deadLineObj = new DeadLine(localDate, LocalDate.now());
        Title titleObj = new Title(title);
        Task task = new Task(titleObj, deadLineObj);
        return taskRepository.save(task);
    }
}
