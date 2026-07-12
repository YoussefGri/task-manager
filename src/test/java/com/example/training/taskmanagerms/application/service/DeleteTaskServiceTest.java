package com.example.training.taskmanagerms.application.service;

import com.example.training.taskmanagerms.application.port.out.TaskRepository;
import com.example.training.taskmanagerms.domain.exception.TaskNotFoundException;
import com.example.training.taskmanagerms.domain.model.DeadLine;
import com.example.training.taskmanagerms.domain.model.Task;
import com.example.training.taskmanagerms.domain.model.Title;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeleteTaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private DeleteTaskService deleteTaskService;

    @Test
    public void delete_existing_task_test() {
        Task task = new Task(new Title("une tache"),
                new DeadLine(LocalDate.now().plusDays(1), LocalDate.now()));
        UUID id = task.getId();
        when(taskRepository.findById(id)).thenReturn(Optional.of(task));

        deleteTaskService.deleteTask(id);

        verify(taskRepository).deleteById(id);
    }

    @Test
    public void delete_missing_task_test() {
        UUID id = UUID.randomUUID();
        when(taskRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class,
                () -> deleteTaskService.deleteTask(id));

        verify(taskRepository, never()).deleteById(id);
    }
}