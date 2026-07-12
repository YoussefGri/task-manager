package com.example.training.taskmanagerms.application.service;

import com.example.training.taskmanagerms.application.port.out.TaskRepository;
import com.example.training.taskmanagerms.domain.model.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateTaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private CreateTaskService createTaskService;

    @Test
    void save_task(){

        /*
        * thenAnswer(...) — au lieu de fixer une valeur de retour à l'avance (comme thenReturn),
        * tu fournis une fonction qui calcule la réponse au moment où le mock est appelé.
        * Cette fonction reçoit un objet invocation qui décrit l'appel en cours.
        * invoation — c'est l'appel intercepté. Il contient quelle méthode a été appelée, avec quels arguments.
        * Mockito te le passe pour que tu puisses réagir en fonction.
        * invocation.getArgument(0) — récupère le premier argument (index 0) de l'appel.
        * Comme la signature est save(Task task), l'argument 0 est justement la Task que le use case vient de construire et de passer à save.
        * */

        when(taskRepository.save(any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Task savedTask = createTaskService.createTask("test test", java.time.LocalDate.now().plusDays(1).toString());

        verify(taskRepository).save(any(Task.class)); // vérif comportement : save appelé
        assertEquals("test test", savedTask.getTitle().getValue());


    }


}
