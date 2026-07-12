package com.example.training.taskmanagerms.domain.model;

import com.example.training.taskmanagerms.domain.exception.TaskAlreadyFinishedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskTest {

    private static Title title;
    private static DeadLine deadLine;

    @BeforeAll
    static void setup() {
         title = new Title("test titre");
         deadLine = new DeadLine(java.time.LocalDate.now().plusDays(1), java.time.LocalDate.now());
    }

    @Test
    public void test_task_constructor() {
        Task task = new Task(title, deadLine);
        assertEquals(Status.TODO, task.getStatus());
    }

    @Test
    public void test_end_task(){
        Task task = new Task(title, deadLine);
        task.end();
        assertEquals(Status.DONE, task.getStatus());
    }

    @Test
    public void test_end_task_already_done() {
        Task task = new Task(title, deadLine);
        task.end();

        assertThrows(TaskAlreadyFinishedException.class, () -> task.end());
    }
}
