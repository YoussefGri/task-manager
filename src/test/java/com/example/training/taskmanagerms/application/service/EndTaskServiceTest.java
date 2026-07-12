package com.example.training.taskmanagerms.application.service;

import com.example.training.taskmanagerms.application.port.out.TaskRepository;
import com.example.training.taskmanagerms.domain.exception.TaskNotFoundException;
import com.example.training.taskmanagerms.domain.model.DeadLine;
import com.example.training.taskmanagerms.domain.model.Status;
import com.example.training.taskmanagerms.domain.model.Task;
import com.example.training.taskmanagerms.domain.model.Title;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EndTaskServiceTest {

    private Task task;
    private DeadLine  deadLine;
    private Title title;

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private EndTaskService endTaskService;

    @BeforeEach
    void setup() {
            deadLine = new DeadLine(LocalDate.now().plusDays(1), LocalDate.now());
            title = new Title("task to end");
            task = new Task(title, deadLine);
    }

    @Test
    public void task_found_test() {
        when(taskRepository.findById(task.getId()))
                .thenReturn(java.util.Optional.of(task));

        endTaskService.endTask(task.getId());

        verify(taskRepository).findById(task.getId());
        assertEquals(Status.DONE, task.getStatus());

    }

    @Test
    public void task_not_found_test() {
        assertThrows(TaskNotFoundException.class,
                () -> endTaskService.endTask(UUID.randomUUID()));
    }

}
