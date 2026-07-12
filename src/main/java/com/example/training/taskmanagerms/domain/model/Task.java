package com.example.training.taskmanagerms.domain.model;

import com.example.training.taskmanagerms.domain.exception.TaskAlreadyFinishedException;
import lombok.Getter;

import java.util.Optional;
import java.util.UUID;

@Getter
public class Task {

    private UUID id;
    private Title title;
    private Optional<DeadLine> deadLine;
    private Status status;

    public Task(Title title, DeadLine deadLine) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.deadLine = Optional.ofNullable(deadLine);
        this.status = Status.TODO;
    }

    public void end() {
        if (this.status == Status.DONE) {
            throw new TaskAlreadyFinishedException("Task is already finished");
        }
        this.status = Status.DONE;
    }
}
