package com.example.training.taskmanagerms.application.service;

import com.example.training.taskmanagerms.application.port.out.TaskRepository;
import com.example.training.taskmanagerms.domain.model.DeadLine;
import com.example.training.taskmanagerms.domain.model.Task;
import com.example.training.taskmanagerms.domain.model.Title;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListTasksServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private ListTasksService listTasksService;

    @Test
    public void list_tasks_test() {
        Task task = new Task(new Title("une tache"),
                new DeadLine(LocalDate.now().plusDays(1), LocalDate.now()));
        when(taskRepository.findAll()).thenReturn(List.of(task));

        List<Task> tasks = listTasksService.listTasks();

        assertThat(tasks).containsExactly(task);
    }
}